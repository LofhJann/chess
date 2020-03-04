package chess.engine.piece;

// TODO: Implement castling
public class King extends Piece {
    public static final int[] EVAL_ARRAY = {
            -30, -40, -40, -50, -50, -40, -40, -30,
            -30, -40, -40, -50, -50, -40, -40, -30,
            -30, -40, -40, -50, -50, -40, -40, -30,
            -30, -40, -40, -50, -50, -40, -40, -30,
            -20, -30, -30, -40, -40, -30, -30, -20,
            -10, -20, -20, -20, -20, -20, -20, -10,
            20, 20, 0, 0, 0, 0, 20, 20,
            20, 30, 10, 0, 0, 10, 30, 20
    };

    protected static final Direction[] directions = {Direction.NORTH,
            Direction.SOUTH,
            Direction.EAST,
            Direction.WEST,
            Direction.SOUTHEAST,
            Direction.SOUTHWEST,
            Direction.NORTHWEST,
            Direction.NORTHEAST
    };

    public King(Color color) {
        super('K', directions, color, 900);
    }

    public King(Color color, int position) {
        super('K', directions, color, 900, position);
    }

    @Override
    public boolean isPseudoLegalMove(int targetSquare) {
        for (Direction direction : getMoveDirections()) {
            if (direction.intValue + getPosition() == targetSquare) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPseudoLegalMove(int targetSquare, Direction direction) {
        return targetSquare == direction.intValue + getPosition();
    }
}
