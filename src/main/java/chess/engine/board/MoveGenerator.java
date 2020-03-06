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

    /**
     * Create pseudolegal moves, current implementation also checks for pieces being blocked (which should really be
     * part of generateLegalMoves)
     * @param board Representation of board
     * @param currentPlayer Color of player in turn
     * @return ArrayList with Pseudolegal moves
     */
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

    /**
     * Checks if targetSquare is legal square on board
     * @param targetSquare index of Target Square
     * @return Boolean if square is on board
     */
    private static boolean targetIsLegalSquare(int targetSquare) {
        return targetSquare >= Square.A1.getIntValue() && targetSquare <= Square.H8.getIntValue() && (targetSquare & 0x88) == 0;
    }

    /**
     * Generate Pawn captures
     * @param board Representation of board
     * @param moves ArrayList of currently generated moves
     * @param color Color of current player in turn
     */
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

    /**
     * Adds Pawn capture to List supplied if it's legal
     * @param board Representation of board
     * @param moves ArrayList of currently generated moves
     * @param color Color of current player in turn
     * @param piece Pawn that did capture
     * @param captureSquare Index of target square where capture takes place
     */
    private static void addPawnCaptureIfPseudoLegal(Board board, ArrayList<Move> moves, Color color, Piece piece, int captureSquare) {
        if (targetIsLegalSquare(captureSquare) &&
                !board.squareIsEmpty(captureSquare)
                && board.getSquarePieceColor(captureSquare) != color) {
            moves.add(new Move(Square.valueOf(Square.getString(piece.getPosition())), Square.valueOf(Square.getString(captureSquare))));
        }
    }

    /**
     * Add move to list
     * @param moves ArrayList of currently generated moves
     * @param startingSquare Index of starting square
     * @param targetSquare Index of end square
     */
    private static void addMove(ArrayList<Move> moves, int startingSquare, int targetSquare) {
        moves.add(
                new Move(Enum.valueOf(Square.class, Square.getString(startingSquare)),
                        Enum.valueOf(Square.class, Square.getString(targetSquare))));
    }

    /**
     * Return pieces of player given
     * @param board Representation of board
     * @param color Color of pieces to return
     * @return Return ArrayList of Pieces according to parameters supplied
     */
    private static ArrayList<Piece> getPieceList(Board board, Color color) {
        if (color == Color.BLACK) {
            return board.getBlackPieces();
        } else if (color == Color.WHITE) {
            return board.getWhitePieces();
        }

        throw new IllegalArgumentException("Color must be either black or white!");
    }
}
