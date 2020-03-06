package chess.engine.piece;

public class Rook extends Piece {
    public static final int[] EVAL_ARRAY = {
            0, 0, 0, 0, 0, 0, 0, 0,
            5, 10, 10, 10, 10, 10, 10, 5,
            -5, 0, 0, 0, 0, 0, 0, -5,
            -5, 0, 0, 0, 0, 0, 0, -5,
            -5, 0, 0, 0, 0, 0, 0, -5,
            -5, 0, 0, 0, 0, 0, 0, -5,
            -5, 0, 0, 0, 0, 0, 0, -5,
            0, 0, 0, 5, 5, 0, 0, 0
    };

    private static final Direction[] directions = {Direction.NORTH,
            Direction.SOUTH,
            Direction.EAST,
            Direction.WEST
    };

    public Rook(Color color) {
        super('R', directions, color, 50);
    }

    public Rook(Color color, int position) {
        super('R', directions, color, 50, position);
    }
}
