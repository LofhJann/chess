package chess.engine.board;

import chess.engine.piece.Color;
import chess.engine.piece.Direction;
import chess.engine.piece.Piece;
import data.ArrayList;

public class MoveGenerator {

    public static ArrayList<Move> generateLegalMoves(Board board, Color currentPlayer) {

        // TODO: fix me
        return generatePseudoLegalMoves(board, currentPlayer);
    }

    private static ArrayList<Move> generatePseudoLegalMoves(Board board, Color currentPlayer) {
        ArrayList<Move> moves = new ArrayList<>();

        for (Piece piece : getPieceList(board, currentPlayer)) {
            int startingSquare = piece.getPosition();
            for (Direction direction : piece.getMoveDirections()) {

                for (int targetSquare = startingSquare + direction.intValue;
                     targetSquare >= Square.A1.getIntValue() && targetSquare <= Square.H8.getIntValue() && (targetSquare & 0x88) == 0;
                     targetSquare += direction.intValue) {
                    if (piece.isPseudoLegalMove(targetSquare, direction)) {
                        moves.add(new Move(Square.getString(startingSquare), Square.getString(targetSquare)));
                    }
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
