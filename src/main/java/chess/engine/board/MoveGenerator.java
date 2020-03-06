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

    protected static ArrayList<Move> generatePseudoLegalMoves(Board board, Color currentPlayer) {
        ArrayList<Move> moves = new ArrayList<>();

        for (Piece piece : getPieceList(board, currentPlayer)) {
            int startingSquare = piece.getPosition();
            for (Direction direction : piece.getMoveDirections()) {

                for (int targetSquare = startingSquare + direction.intValue; targetIsLegalSquare(targetSquare); targetSquare += direction.intValue) {

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

    private static boolean targetIsLegalSquare(int targetSquare) {
        return targetSquare >= Square.A1.getIntValue() && targetSquare <= Square.H8.getIntValue() && (targetSquare & 0x88) == 0;
    }

    private static void generatePawnCaptures(Board board, ArrayList<Move> moves, Color color) {
        for (Piece piece : getPieceList(board, color)) {
            if (piece.getClass() == Pawn.class) {
                int leftCaptureSquare = color == Color.WHITE
                        ? piece.getPosition() + Direction.NORTHWEST.intValue
                        : piece.getPosition() + Direction.SOUTHWEST.intValue;
                int rightCaptureSquare = color == Color.WHITE
                        ? piece.getPosition() + Direction.NORTHEAST.intValue
                        : piece.getPosition() + Direction.SOUTHEAST.intValue;

                addPawnCaptureIfPseudoLegal(board, moves, color, piece, leftCaptureSquare);
                addPawnCaptureIfPseudoLegal(board, moves, color, piece, rightCaptureSquare);
            }
        }
    }

    private static void addPawnCaptureIfPseudoLegal(Board board, ArrayList<Move> moves, Color color, Piece piece, int captureSquare) {
        if (targetIsLegalSquare(captureSquare) &&
                !board.squareIsEmpty(captureSquare)
                && board.getSquarePieceColor(captureSquare) != color) {
            moves.add(new Move(Square.valueOf(Square.getString(piece.getPosition())), Square.valueOf(Square.getString(captureSquare))));
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
