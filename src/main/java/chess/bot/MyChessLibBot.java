package chess.bot;

import chess.engine.GameState;
import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Piece;
import com.github.bhlangonijr.chesslib.Square;
import com.github.bhlangonijr.chesslib.game.GameContext;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveGeneratorException;
import data.NegaMax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
        if (countPieces() <= 7) {
            try {
                return getMoveFromEndgameTables();
            } catch (IOException ignored) {
            } catch (InterruptedException ignored) {
            }
        }
        try {
            myMove = this.getMove();

            if (myMove != null) {
                return myMove.toString();
            }
        } catch (MoveGeneratorException ignored) {
        }
        return null;
    }

    private int countPieces() {
        int count = 0;
        for (Piece piece : board.boardToArray()) {
            if (piece != Piece.NONE) {
                count++;
            }
        }
        return count;
    }

    public String getMoveFromEndgameTables() throws IOException, InterruptedException {
        String fen = board.getFen();
        fen = fen.replace(" ", "_");
        URL url = new URL("http://tablebase.lichess.ovh/standard/mainline?fen=" + fen);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "text/plain");
        con.setRequestProperty("charset", "utf-8");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        String[] contentArray = content.toString().split("uci");


        return contentArray[1].split("\"")[2];
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

    public Move getMove() throws MoveGeneratorException {
        return new NegaMax(board).negaMax();
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
