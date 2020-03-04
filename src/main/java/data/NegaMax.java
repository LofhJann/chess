package data;


import chess.engine.board.Board;
import chess.engine.board.Move;
import chess.engine.board.MoveGenerator;

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

    public Move negaMax() {
        ArrayList<Move> moves = MoveGenerator.generateLegalMoves(board, board.getPlayerInTurn());

        for (Move move : moves) {
            board.makeMove(move);
            int evaluationResult = -evaluateNegaMax(INITIAL_DEPTH, Integer.MIN_VALUE, Integer.MAX_VALUE);
            board.unmakeMove();

            if (evaluationResult > max) {
                max = evaluationResult;
                bestMove = move;
            }

        }

        return bestMove;
    }

    private int evaluateNegaMax(int depth, int alpha, int beta) {
        if (depth == 0) {
            return board.evaluatePosition();
        }

        int bestValue = Integer.MIN_VALUE;

        ArrayList<Move> moves = MoveGenerator.generateLegalMoves(board, board.getPlayerInTurn());

        for (Move move : moves) {
            board.makeMove(move);
            int value = -evaluateNegaMax(depth - 1, -beta, -alpha);
            board.unmakeMove();

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
}
