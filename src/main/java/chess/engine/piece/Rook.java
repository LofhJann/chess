package chess.engine.piece;

import chess.engine.Color;
import chess.engine.Direction;

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

    public Rook(Color color) {
        super('R', new Direction[]{Direction.NORTH,
                Direction.SOUTH,
                Direction.EAST,
                Direction.WEST
        }, color, 50);
    }
}
