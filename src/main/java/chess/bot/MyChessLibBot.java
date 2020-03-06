package chess.bot;

import chess.engine.GameState;
import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Piece;
import com.github.bhlangonijr.chesslib.Square;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveGeneratorException;
import data.NegaMax;

//TODO: Replace libraries with own implementations!


public class MyChessLibBot implements ChessBot {
    private Board board;

    public MyChessLibBot() {
        this.board = new Board();
    }

    @Override
    public String nextMove(GameState gamestate) {
        parseLatestMove(gamestate);
        Move myMove;
        try {
            myMove = this.getMove();

            if (myMove != null) {
                return myMove.toString();
            }
        } catch (MoveGeneratorException ignored) {
        }
        return null;
    }

    // TODO: Replace with own implementation
    public void parseLatestMove(GameState gs) {
        this.board = new Board();

        // We play all of the moves onto a new board to ensure a previously
        // started game can be resumed correctly, inefficient but it works
        if (!gs.moves.isEmpty()) {
            gs.moves.forEach(moveString -> {
                String startingString = moveString.substring(0, 2).toUpperCase();
                String endingString = moveString.substring(2, 4).toUpperCase();
                String promoteString = moveString.length() > 4 ? moveString
                        .substring(4).toUpperCase() : "".toUpperCase();
                this.setMove(startingString, endingString, promoteString);
            });
        }
    }

    // TODO: Replace
    public Move getMove() throws MoveGeneratorException {
        //return new NegaMax(board).negaMax();
        return new Move(Square.A1, Square.A2);
    }

    // TODO: Replace with own implementation
    public void setMove(String starting, String ending, String promote) {
        String promotionPiece = "";
        if (promote.length() > 0) {
            Piece piece = board.getPiece(Square.valueOf(starting));
            String side = piece.getPieceSide().value();
            switch (promote) {
                case "R":
                    promotionPiece = side + "_ROOK";
                    break;
                case "B":
                    promotionPiece = side + "_BISHOP";
                    break;
                case "N":
                    promotionPiece = side + "_KNIGHT";
                    break;
                case "Q":
                    promotionPiece = side + "_QUEEN";
                    break;
                default:
                    throw new Error("Something went wrong parsing the promoted piece");
            }
        }
        Move latestMove = promote.isEmpty() ? new Move(
                Square.fromValue(starting),
                Square.valueOf(ending)) : new Move(Square.fromValue(starting),
                Square.valueOf(ending), Piece.fromValue(promotionPiece));
        this.board.doMove(latestMove);
    }
}
