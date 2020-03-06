package data;


import chess.engine.piece.*;
import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Piece;
import com.github.bhlangonijr.chesslib.Side;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveGenerator;
import com.github.bhlangonijr.chesslib.move.MoveGeneratorException;
import com.github.bhlangonijr.chesslib.move.MoveList;

import static com.github.bhlangonijr.chesslib.PieceType.*;

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

    public Move negaMax() throws MoveGeneratorException {
        MoveList moves = MoveGenerator.generateLegalMoves(board);

        for (Move move : moves) {
            board.doMove(move);
            int evaluationResult = -evaluateNegaMax(INITIAL_DEPTH, Integer.MIN_VALUE, Integer.MAX_VALUE);
            board.undoMove();

            if (evaluationResult > max) {
                max = evaluationResult;
                bestMove = move;
            }

        }

        return bestMove;
    }

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
                    pieceValue += 1;
                    pieceValue += Pawn.EVAL_ARRAY[i];
                    break;
                case BISHOP:
                    pieceValue += 30;
                    pieceValue += Bishop.EVAL_ARRAY[i];
                    break;
                case KNIGHT:
                    pieceValue += 30;
                    pieceValue += Knight.EVAL_ARRAY[i];
                    break;
                case ROOK:
                    pieceValue += 50;
                    pieceValue += Rook.EVAL_ARRAY[i];
                    break;
                case QUEEN:
                    pieceValue += 90;
                    pieceValue += Queen.EVAL_ARRAY[i];
                    break;
                case KING:
                    pieceValue += 900;
                    pieceValue += King.EVAL_ARRAY[i];
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
