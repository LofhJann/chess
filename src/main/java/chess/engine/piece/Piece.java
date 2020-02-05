package chess.engine.piece;

import chess.engine.Color;
import chess.engine.Direction;

public abstract class Piece {

    private final char pieceSymbol;
    private final Direction[] moveDirections;
    private int position; //TODO: Implement
    private Color color;
    private int value;

    public Piece(char pieceSymbol, Direction[] moveDirections, Color color, int value) {
        this.pieceSymbol = pieceSymbol;
        this.moveDirections = moveDirections;
        this.color = color;
        this.value = value;
    }

    public boolean isLegalDirection(int targetSquare) {
        // TODO: Implement pieces blocking movement check.
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

}
