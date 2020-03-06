package chess.bot;

import chess.engine.GameState;
import chess.engine.board.Board;
import chess.engine.board.Move;
import data.NegaMax;

public class MyOwnBot implements ChessBot {
    private Board board;

    public MyOwnBot() {
        this.board = new Board();
    }

    // TODO: Finish this
    @Override
    public String nextMove(GameState gamestate) {
//        if (!gamestate.moves.isEmpty()) {
//            board.updateBoardAfterMove(new Move(gamestate.moves.get(gamestate.moves.size() - 1)));
//        }
//        Move move = new NegaMax(board).negaMax();
//        board.updateBoardAfterMove(move);
//        return move.toString();
        return null;
    }
}
