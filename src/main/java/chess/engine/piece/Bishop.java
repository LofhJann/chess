package chess.engine.piece;

import chess.engine.Color;
import chess.engine.Direction;

public class Bishop extends Piece {
    private static final int[] EVAL_ARRAY = {
            -20, -10, -10, -10, -10, -10, -10, -20,
            -10, 0, 0, 0, 0, 0, 0, -10,
            -10, 0, 5, 10, 10, 5, 0, -10,
            -10, 5, 5, 10, 10, 5, 5, -10,
            -10, 0, 10, 10, 10, 10, 0, -10,
            -10, 10, 10, 10, 10, 10, 10, -10,
            -10, 5, 0, 0, 0, 0, 5, -10,
            -20, -10, -10, -10, -10, -10, -10, -20};

    public static final Direction[] directions = {Direction.NORTHEAST, Direction.NORTHWEST, Direction.SOUTHEAST, Direction.SOUTHWEST};

    public Bishop(Color color) {
        super('B', directions, color, 30);
    }

    public Bishop(Color color, int position) {
        super('B', directions, color, 30, position);
    }
}
