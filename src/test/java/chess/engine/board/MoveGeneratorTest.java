package chess.engine.board;

import chess.engine.board.Board;
import chess.engine.board.Move;
import chess.engine.board.MoveGenerator;
import chess.engine.piece.Color;
import data.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class MoveGeneratorTest {


    @Test
    public void centeredQueenMovesGeneratedCorrectly() {
        Board board = new Board("8/8/8/3q");

        ArrayList<Move> moves = MoveGenerator.generatePseudoLegalMoves(board, Color.WHITE);

        Assert.assertEquals(27, moves.size());
    }

    @Test
    public void pawnMovesGeneratedCorrectly() {
        Board board = new Board("8/p");

        ArrayList<Move> moves = MoveGenerator.generatePseudoLegalMoves(board, Color.WHITE);

        Assert.assertEquals(2, moves.size());

        board = new Board("8/8/8/8/8/8/P");
        moves = MoveGenerator.generatePseudoLegalMoves(board, Color.BLACK);
        Assert.assertEquals(2, moves.size());
    }

    @Test
    public void kingMovesGeneratedCorrectly() {
        Board board = new Board("8/8/8/3k");

        ArrayList<Move> moves = MoveGenerator.generatePseudoLegalMoves(board, Color.WHITE);

        Assert.assertEquals(8, moves.size());
    }

    @Test
    public void rookMovesGeneratedCorrectly() {
        Board board = new Board("8/8/8/3r");

        ArrayList<Move> moves = MoveGenerator.generatePseudoLegalMoves(board, Color.WHITE);

        Assert.assertEquals(14, moves.size());
    }

    @Test
    public void bishopMovesGeneratedCorrectly() {
        Board board = new Board("8/8/8/3b");

        ArrayList<Move> moves = MoveGenerator.generatePseudoLegalMoves(board, Color.WHITE);

        Assert.assertEquals(13, moves.size());
    }

    @Test
    public void knightMovesGeneratedCorrectly() {
        Board board = new Board("8/8/8/3n");

        ArrayList<Move> moves = MoveGenerator.generatePseudoLegalMoves(board, Color.WHITE);

        Assert.assertEquals(8, moves.size());
    }

    @Test
    public void piecesAreCorrectlyBlockedByOtherPieces() {
        Board board = new Board("8/8/2PPP/2PqP/2PPP");

        ArrayList<Move> moves = MoveGenerator.generatePseudoLegalMoves(board, Color.WHITE);

        Assert.assertEquals(8, moves.size());
    }

    @Test
    public void piecesAreCorrectlyBlockedByOwnPieces() {
        Board board = new Board("8/8/2ppp/2pqp/2ppp");

        ArrayList<Move> moves = MoveGenerator.generatePseudoLegalMoves(board, Color.WHITE);

        Assert.assertEquals(3, moves.size());
    }

    @Test
    public void pawnCapturesAreGeneratedCorrectly() {
        Board board = new Board("8/8/1p6/P1P5");

        ArrayList<Move> moves = MoveGenerator.generatePseudoLegalMoves(board, Color.WHITE);

        Assert.assertEquals(3, moves.size());

        board = new Board("8/8/8/p1p5/1P6/");

        moves = MoveGenerator.generatePseudoLegalMoves(board, Color.BLACK);

        Assert.assertEquals(3, moves.size());
    }

    @Test
    public void legalMovesAreGeneratedCorrectly() {
        Board board = new Board();

        ArrayList<Move> moves = MoveGenerator.generateLegalMoves(board, Color.WHITE);


    }
}
