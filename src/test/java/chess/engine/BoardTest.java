package chess.engine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class BoardTest {

    private char[] testBoard = new char[128];

    //TODO: Replace with Square names
    @Before
    public void initTestBoard() {
        testBoard[Square.A1.getIntValue()] = 'r';
        testBoard[Square.B1.getIntValue()] = 'n';
        testBoard[Square.C1.getIntValue()] = 'b';
        testBoard[Square.D1.getIntValue()] = 'q';
        testBoard[Square.E1.getIntValue()] = 'k';
        testBoard[Square.F1.getIntValue()]= 'b';
        testBoard[Square.G1.getIntValue()] = 'n';
        testBoard[Square.H1.getIntValue()] = 'r';
        testBoard[Square.A2.getIntValue()] = 'p';
        testBoard[Square.B2.getIntValue()] = 'p';
        testBoard[Square.C2.getIntValue()] = 'p';
        testBoard[Square.D2.getIntValue()] = 'p';
        testBoard[Square.E2.getIntValue()] = 'p';
        testBoard[Square.F2.getIntValue()] = 'p';
        testBoard[Square.G2.getIntValue()] = 'p';
        testBoard[Square.H2.getIntValue()] = 'p';
        testBoard[Square.A7.getIntValue()] = 'P';
        testBoard[Square.B7.getIntValue()] = 'P';
        testBoard[Square.C7.getIntValue()] = 'P';
        testBoard[Square.D7.getIntValue()] = 'P';
        testBoard[Square.E7.getIntValue()] = 'P';
        testBoard[Square.F7.getIntValue()] = 'P';
        testBoard[Square.G7.getIntValue()] = 'P';
        testBoard[Square.H7.getIntValue()] = 'P';
        testBoard[Square.A8.getIntValue()] = 'R';
        testBoard[Square.B8.getIntValue()] = 'N';
        testBoard[Square.C8.getIntValue()] = 'B';
        testBoard[Square.D8.getIntValue()] = 'Q';
        testBoard[Square.E8.getIntValue()] = 'K';
        testBoard[Square.F8.getIntValue()]= 'B';
        testBoard[Square.G8.getIntValue()] = 'N';
        testBoard[Square.H8.getIntValue()] = 'R';
    }

    @Test
    public void testBoardIsGeneratedCorrectlyInSetup() {
        Board board = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1\n");

        for (int i = 0; i < testBoard.length; i++) {
            if (board.getBoard()[i] != testBoard[i]) {
                fail("Index " + i + " did not match! (" + "expected '" + testBoard[i] + "' got '" + board.getBoard()[i] + "')");
            }
        }
    }

    @Test
    public void squareToBoardIndexWorksCorrect() {
        Board board = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1\n");

        assertEquals(Square.A1.getIntValue(), board.squareToBoardIndex("a1"));
        assertEquals(Square.H8.getIntValue(), board.squareToBoardIndex("h8"));
        assertEquals(Square.B6.getIntValue(), board.squareToBoardIndex("b6"));
        assertEquals("Uppercase was not handled correctly",
                Square.B6.getIntValue(), board.squareToBoardIndex("B6"));

    }

}
