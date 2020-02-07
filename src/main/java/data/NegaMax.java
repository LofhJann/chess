package data;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveGenerator;
import com.github.bhlangonijr.chesslib.move.MoveGeneratorException;
import com.github.bhlangonijr.chesslib.move.MoveList;

// TODO: Replace imports with own once done
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

    public int evaluateNegaMax(int depth, int alpha, int beta) throws MoveGeneratorException {
        if (depth == 0) {
            return calculateValueFromFEN(board.getFen());
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

    public int calculateValueFromFEN(String fenString) {
        // TODO: Add square based evaluation
        int value = 0;
        for (int i = 0; i < fenString.length(); i++) {
            switch (fenString.charAt(i)) {
                case ' ':
                    return value;
                case 'P':
                    value += 1;
                    break;
                case 'p':
                    value -= 1;
                    break;
                case 'b':
                    value -= 30;
                    break;
                case 'B':
                    value += 30;
                    break;
                case 'N':
                    value += 30;
                    break;
                case 'n':
                    value -= 30;
                    break;
                case 'R':
                    value += 50;
                    break;
                case 'r':
                    value -= 50;
                    break;
                case 'Q':
                    value += 90;
                    break;
                case 'q':
                    value -= 90;
                    break;
                case 'K':
                    value += 900;
                    break;
                case 'k':
                    value -= 900;
                    break;
                default:
                    break;
            }
        }
        return value;
    }
}
