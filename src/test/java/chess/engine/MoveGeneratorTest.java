package chess.engine;

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

        ArrayList<Move> moves = MoveGenerator.generateLegalMoves(board, Color.WHITE);

        Assert.assertEquals(28, moves.size());
    }

    @Test
    public void pawnMovesGeneratedCorrectly() {
        Board board = new Board("8/p");

        ArrayList<Move> moves = MoveGenerator.generateLegalMoves(board, Color.WHITE);

        Assert.assertEquals(2, moves.size());
    }
}
