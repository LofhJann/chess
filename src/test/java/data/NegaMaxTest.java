package data;

import chess.engine.board.Board;
import org.junit.Test;

public class NegaMaxTest {

    @Test
    public void negaMaxDoesntThrowException() {
        Board board = new Board();

        NegaMax negaMax = new NegaMax(board);

        negaMax.negaMax();
    }
}
