package data;


import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.MoveGeneratorException;
import org.junit.Test;

public class NegaMaxTest {

    @Test
    public void negaMaxDoesntThrowException() throws MoveGeneratorException {
        Board board = new Board();

        NegaMax negaMax = new NegaMax(board);

        negaMax.negaMax();
    }
}
