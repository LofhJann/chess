package chess.engine.piece;

import chess.engine.board.Square;

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

    public boolean isPseudoLegalMove(int targetSquare) {
        if (targetSquare < Square.A1.getIntValue() || targetSquare > Square.H8.getIntValue()) {
            return false;
        }
        for (Direction direction : moveDirections) {
            if (targetSquare % direction.intValue == 0) {
                return true;
            }
        }
        return false;
    }

    public char getPieceSymbol() {
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
}
