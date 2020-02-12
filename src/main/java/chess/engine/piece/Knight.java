package chess.engine.piece;

public class Knight extends Piece {
    public static final int[] EVAL_ARRAY = {
            -50, -40, -30, -30, -30, -30, -40, -50,
            -40, -20, 0, 0, 0, 0, -20, -40,
            -30, 0, 10, 15, 15, 10, 0, -30,
            -30, 5, 15, 20, 20, 15, 5, -30,
            -30, 0, 15, 20, 20, 15, 0, -30,
            -30, 5, 10, 15, 15, 10, 5, -30,
            -40, -20, 0, 5, 5, 0, -20, -40,
            -50, -40, -30, -30, -30, -30, -40, -50
    };

    public static final Direction[] directions = {
            Direction.KNIGHT_EASTNORTH, Direction.KNIGHT_EASTSOUTH, Direction.KNIGHT_NORTHEAST, Direction.KNIGHT_NORTHWEST,
            Direction.KNIGHT_SOUTHEAST, Direction.KNIGHT_SOUTHWEST, Direction.KNIGHT_WESTNORTH, Direction.KNIGHT_WESTSOUTH
    };

    public Knight(Color color) {
        super('N', directions, color, 30);
    }

    public Knight(Color color, int position) {
        super('N', directions, color, 30, position);
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
