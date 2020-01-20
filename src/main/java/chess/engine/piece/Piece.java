package chess.engine.piece;

import chess.engine.Direction;

public abstract class Piece {

    private final char pieceSymbol;
    private final Direction[] moveDirections;

    public Piece(char pieceSymbol, Direction[] moveDirections) {
        this.pieceSymbol = pieceSymbol;
        this.moveDirections = moveDirections;
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

}
