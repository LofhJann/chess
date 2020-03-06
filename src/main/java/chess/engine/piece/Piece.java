package chess.engine.piece;

import chess.engine.board.Square;
import util.Math;

public abstract class Piece {

    private final char pieceSymbol;
    private final Direction[] moveDirections;
    private int position;
    private Color color;
    private int value;

    public Piece(char pieceSymbol, Direction[] moveDirections, Color color, int value) {
        this.pieceSymbol = pieceSymbol;
        this.moveDirections = moveDirections;
        this.color = color;
        this.value = value;
    }

    public Piece(char pieceSymbol, Direction[] moveDirections, Color color, int value, int position) {
        this.pieceSymbol = pieceSymbol;
        this.moveDirections = moveDirections;
        this.color = color;
        this.value = value;
        this.position = position;
    }

    /**
     * Checks if in theory Piece could move in given square
     * @param targetSquare square to move to
     * @return Boolean if move is possible, given it's not blocked by other pieces
     */
    public boolean isPseudoLegalMove(int targetSquare) {
        if (targetSquare <= Square.A1.getIntValue() || targetSquare >= Square.H8.getIntValue() || (targetSquare & 0x88) != 0) {
            return false;
        }
        for (Direction direction : moveDirections) {
            if (Math.abs(targetSquare - getPosition()) % direction.intValue == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isPseudoLegalMove(int targetSquare, Direction direction) {
        if (targetSquare < Square.A1.getIntValue() || targetSquare > Square.H8.getIntValue() || (targetSquare & 0x88) != 0) {
            return false;
        }
        return Math.abs(targetSquare - getPosition()) % direction.intValue == 0;
    }

    public char getPieceSymbol() {
        if (color.equals(Color.WHITE)) {
            return Character.toLowerCase(pieceSymbol);
        }

        return pieceSymbol;

    }

    public Direction[] getMoveDirections() {
        return moveDirections;
    }

    public int getValue() {
        return value * color.getIntValue();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (pieceSymbol != piece.pieceSymbol) return false;
        if (position != piece.position) return false;
        return color == piece.color;
    }

    @Override
    public int hashCode() {
        int result = pieceSymbol;
        result = 31 * result + position;
        result = 31 * result + color.hashCode();
        return result;
    }
}
