package chess.engine.piece;

import chess.engine.Color;
import chess.engine.Direction;

public class King extends Piece {
    public King(Color color) {
        super('K', new Direction[]{Direction.NORTH,
                Direction.SOUTH,
                Direction.EAST,
                Direction.WEST,
                Direction.SOUTHEAST,
                Direction.SOUTHWEST,
                Direction.NORTHWEST,
                Direction.NORTHEAST
        }, color, 900);
    }

    @Override
    public boolean isLegalDirection(int targetSquare) {
        for (Direction direction : getMoveDirections()) {
            if (direction.intValue == targetSquare) {
                return true;
            }
        }
        return false;
    }
}
