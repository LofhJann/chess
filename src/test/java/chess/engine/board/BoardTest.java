package chess.engine;

import chess.engine.board.Board;
import chess.engine.board.Move;
import chess.engine.board.Square;
import chess.engine.piece.Piece;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class BoardTest {

    private static final String initialFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1\n";
    private Board board;

    @Before
    public void initTestBoard() {
        board = new Board(initialFen);
    }

    @Test
    public void testBoardIsGeneratedCorrectlyInSetup() {
        char[] testBoard = new char[128];
        testBoard[Square.A1.getIntValue()] = 'r';
        testBoard[Square.B1.getIntValue()] = 'n';
        testBoard[Square.C1.getIntValue()] = 'b';
        testBoard[Square.D1.getIntValue()] = 'q';
        testBoard[Square.E1.getIntValue()] = 'k';
        testBoard[Square.F1.getIntValue()] = 'b';
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
        testBoard[Square.F8.getIntValue()] = 'B';
        testBoard[Square.G8.getIntValue()] = 'N';
        testBoard[Square.H8.getIntValue()] = 'R';

        for (int i = 0; i < testBoard.length; i++) {
            if (board.getBoardState()[i] != testBoard[i]) {
                fail("Index " + i + " did not match! (" + "expected '" + testBoard[i] + "' got '" + board.getBoardState()[i] + "')");
            }
        }
    }

    @Test
    public void fenStringIsEncodedCorrectly() {
        Board board = new Board(initialFen);

        Assert.assertEquals("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", board.toString());
    }

    @Test
    public void squareToBoardIndexWorksCorrect() {
        assertEquals(Square.A1.getIntValue(), board.squareToBoardIndex("a1"));
        assertEquals(Square.H8.getIntValue(), board.squareToBoardIndex("h8"));
        assertEquals(Square.B6.getIntValue(), board.squareToBoardIndex("b6"));
        assertEquals("Uppercase was not handled correctly",
                Square.B6.getIntValue(), board.squareToBoardIndex("B6"));
    }

    @Test
    public void testUpdateBoardAfterMoveWorksForAMove() {

        Piece pawn = board.getWhitePieces().get(9);

        assertEquals("Incorrect starting square, ignore test result", Square.B2.getIntValue(), pawn.getPosition());

        board.updateBoardAfterMove(new Move(Square.B2, Square.B3));

        assertEquals("Starting square was not correctly cleared", '\u0000', board.getBoardState()[Square.B2.getIntValue()]);
        assertEquals("Ending square was not correctly set", 'p', board.getBoardState()[Square.B3.getIntValue()]);
        assertEquals("Pawns' position was not updated correctly", Square.B3.getIntValue(), pawn.getPosition());

    }

    @Test
    public void testUpdateBoardAfterCapturingMove() {
        Board board = new Board("rR");

        Piece whiteRook = board.getWhitePieces().get(0);

        board.updateBoardAfterMove(new Move(Square.A1, Square.B1));

        assertEquals("Starting square was not correctly cleared", '\u0000', board.getBoardState()[Square.A1.getIntValue()]);
        assertEquals("Ending square was not correctly set", 'r', board.getBoardState()[Square.B1.getIntValue()]);
        assertEquals("Rooks position was not updated correctly", Square.B1.getIntValue(), whiteRook.getPosition());
        assertEquals("Black piece was not removed from list correctly", 0, board.getBlackPieces().size());
    }

    @Test
    public void testEvaluatePosition() {
        board.getBlackPieces().getData()[0] = null;

        assertEquals("Evaluation didn't work when black piece was eaten", 10, board.evaluatePosition(), 0);

        board.getWhitePieces().getData()[0] = null;

        assertEquals("Evaluation didn't work when white piece was eaten", -40, board.evaluatePosition(), 0);
    }

}
