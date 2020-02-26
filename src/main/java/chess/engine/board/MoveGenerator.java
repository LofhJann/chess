package chess.engine.board;

import chess.engine.piece.Color;
import chess.engine.piece.Direction;
import chess.engine.piece.Piece;
import data.ArrayList;

public class MoveGenerator {

    public static ArrayList<Move> generateLegalMoves(Board board) {

        return new ArrayList<>();
    }

    // TODO: Finish and test this
    private static ArrayList<Move> generatePseudoLegalMoves(Board board, Color currentPlayer) {
        ArrayList<Move> moves = new ArrayList<>();

        for (Piece piece : getPieceList(board, currentPlayer)) {
            for (Direction direction : piece.getMoveDirections()) {
                int currentSquare = piece.getPosition();

                while (currentSquare > Square.A1.getIntValue() && currentSquare < Square.H8.getIntValue()) {
                    int targetSquare = currentSquare + direction.intValue;
                    if (piece.isPseudoLegalMove(targetSquare)) {
                        moves.add(new Move(Square.getString(currentSquare), Square.getString(targetSquare)));
                    }
                    currentSquare = targetSquare;
                }
            }
        }
        // TODO: enpassant
        // TODO: Castling



        return moves;
    }

    private static ArrayList<Piece> getPieceList(Board board, Color color) {
        if (color == Color.BLACK) {
            return board.getBlackPieces();
        } else if (color == Color.WHITE) {
            return board.getWhitePieces();
        }

        throw new IllegalArgumentException("Color must be either black or white!");
    }
}
