package data;


import chess.engine.piece.*;
import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Piece;
import com.github.bhlangonijr.chesslib.Side;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveGenerator;
import com.github.bhlangonijr.chesslib.move.MoveGeneratorException;
import com.github.bhlangonijr.chesslib.move.MoveList;

public class NegaMax {
    private static final int INITIAL_DEPTH = 4;
    private Board board;
    private int max;
    private Move bestMove;

    public NegaMax(Board board) {
        this.board = board;
        this.max = Integer.MIN_VALUE;
        this.bestMove = null;
    }

    /**
     * Entrance point to NegaMax algorithm used to search for best move.
     * @return Best move available
     * @throws MoveGeneratorException
     */
    public Move negaMax() throws MoveGeneratorException {
        return negaMax(INITIAL_DEPTH);
    }

    /**
     * Additional entrance point if non-initial depth is wanted.
     * @param depth depth to use in recursive search
     * @return Best move available
     * @throws MoveGeneratorException
     */
    public Move negaMax(int depth) throws MoveGeneratorException {
        MoveList moves = MoveGenerator.generateLegalMoves(board);

        for (Move move : moves) {
            board.doMove(move);
            int evaluationResult = -evaluateNegaMax(depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
            board.undoMove();

            if (evaluationResult > max) {
                max = evaluationResult;
                bestMove = move;
            }

        }

        return bestMove;
    }

    /**
     * Recursion step of NegaMax algorithm
     * @param depth depth
     * @param alpha Alpha for alpha beta pruning
     * @param beta Beta for alpha beta pruning
     * @return Evaluation of position in end of search-tree
     * @throws MoveGeneratorException
     */
    private int evaluateNegaMax(int depth, int alpha, int beta) throws MoveGeneratorException {
        if (depth == 0) {
            return evaluatePosition();
        }

        int bestValue = Integer.MIN_VALUE;

        MoveList moves = MoveGenerator.generateLegalMoves(board);

        for (Move move : moves) {
            board.doMove(move);
            int value = -evaluateNegaMax(depth - 1, -beta, -alpha);
            board.undoMove();

            if (value > bestValue) {
                bestValue = value;
            }

            if (bestValue > alpha) {
                alpha = bestValue;
            }

            if (bestValue >= beta) {
                break;
            }
        }
        return alpha;
    }

    /**
     *
     * @return Evaluation of current position
     */
    private int evaluatePosition() {
        int value = 0;
        Piece[] pieces = board.boardToArray();
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i] == Piece.NONE) {
                continue;
            }
            Side pieceSide = pieces[i].getPieceSide();
            int pieceValue = 0;
            switch (pieces[i].getPieceType()) {
                case PAWN:
                    pieceValue += 10;
                    break;
                case BISHOP:
                    pieceValue += 300;
                    break;
                case KNIGHT:
                    pieceValue += 300;
                    break;
                case ROOK:
                    pieceValue += 500;
                    break;
                case QUEEN:
                    pieceValue += 900;
                    break;
                case KING:
                    pieceValue += 9000;
                    break;
                case NONE:
                    continue;
                default:
                    break;
            }
            if (pieceSide == Side.BLACK) {
                pieceValue *= -1;
            }
            value += pieceValue;
        }

        return value;
    }
}
