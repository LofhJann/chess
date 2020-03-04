package chess.engine.board;

import chess.engine.piece.Color;
import chess.engine.piece.Direction;
import chess.engine.piece.Pawn;
import chess.engine.piece.Piece;
import data.ArrayList;

public class MoveGenerator {

    private MoveGenerator() {
    }

    public static ArrayList<Move> generateLegalMoves(Board board, Color currentPlayer) {

        // TODO: fix me
        ArrayList<Move> pseudoLegalMoves = generatePseudoLegalMoves(board, currentPlayer);

        for (Move move : pseudoLegalMoves) {

        }

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


                    if (!board.squareIsEmpty(targetSquare)) {
                        if (board.getSquarePieceColor(targetSquare) != currentPlayer && piece.getClass() != Pawn.class) {
                            addMove(moves, startingSquare, targetSquare);
                        }
                        break;
                    }
                    if (piece.isPseudoLegalMove(targetSquare, direction)) {
                        addMove(moves, startingSquare, targetSquare);
                    }
                }
            }
        }
        // TODO: enpassant
        // TODO: Castling

        generatePawnCaptures(board, moves, currentPlayer);

        return moves;
    }

    private static void generatePawnCaptures(Board board, ArrayList<Move> moves, Color color) {
        for (Piece piece : getPieceList(board, color)) {
            if (piece.getClass() == Pawn.class) {
                int leftCaptureSquare = piece.getPosition() + Direction.NORTHWEST.intValue;
                int rightCaptureSquare = piece.getPosition() + Direction.NORTHEAST.intValue;

                if (!board.squareIsEmpty(leftCaptureSquare) && board.getSquarePieceColor(leftCaptureSquare) != color) {
                    moves.add(new Move(Square.valueOf(Square.getString(piece.getPosition())), Square.valueOf(Square.getString(leftCaptureSquare))));
                }
                if (!board.squareIsEmpty(rightCaptureSquare) && board.getSquarePieceColor(rightCaptureSquare) != color) {
                    moves.add(new Move(Square.valueOf(Square.getString(piece.getPosition())), Square.valueOf(Square.getString(rightCaptureSquare))));
                }
            }
        }
    }

    private static void addMove(ArrayList<Move> moves, int startingSquare, int targetSquare) {
        moves.add(
                new Move(Enum.valueOf(Square.class, Square.getString(startingSquare)),
                        Enum.valueOf(Square.class, Square.getString(targetSquare))));
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
