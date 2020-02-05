package chess.engine.piece;

import chess.engine.Color;
import chess.engine.Direction;

public class Knight extends Piece {
    public Knight(Color color) {
        super('N', new Direction[]{
                Direction.KNIGHT_EASTNORTH, Direction.KNIGHT_EASTSOUTH, Direction.KNIGHT_NORTHEAST, Direction.KNIGHT_NORTHWEST,
                Direction.KNIGHT_SOUTHEAST, Direction.KNIGHT_SOUTHWEST, Direction.KNIGHT_WESTNORTH, Direction.KNIGHT_WESTSOUTH
        }, color, 30);
    }

    @Override
    public boolean isLegalDirection(int targetSquare) {
        for (Direction direction : getMoveDirections()) {
            if (targetSquare == direction.intValue) {
                return true;
            }
        }
        return false;
    }
}
