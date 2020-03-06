package chess.engine.piece;

public class Rook extends Piece {
    /**
     * Array for position based evaluation for piece
     */
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

    /**
     * Directions where Piece can move
     */
    private static final Direction[] directions = {Direction.NORTH,
            Direction.SOUTH,
            Direction.EAST,
            Direction.WEST
    };

    /**
     * Creates Rook
     * @param color Color of Piece
     */
    public Rook(Color color) {
        super('R', directions, color, 50);
    }

    /**
     * Creates Rook
     * @param color Color of Piece
     * @param position Position of Piece
     */
    public Rook(Color color, int position) {
        super('R', directions, color, 50, position);
    }
}
