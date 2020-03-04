package chess.bot;

import chess.engine.GameState;
import chess.engine.board.Board;
import chess.engine.board.Move;

public class MyOwnBot implements ChessBot {
    private Board board;

    public MyOwnBot(Board board) {
        this.board = board;
    }

    // TODO: Finish this
    @Override
    public String nextMove(GameState gamestate) {
        board.updateBoardAfterMove(new Move(gamestate.moves.get(gamestate.moves.size()-1)));
        return null;
    }
}
