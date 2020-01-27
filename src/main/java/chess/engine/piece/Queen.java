package chess.engine.piece;

import chess.engine.Direction;

public class Queen extends Piece {

    public Queen() {
        super('Q', new Direction[]{Direction.NORTH,
                Direction.SOUTH,
                Direction.EAST,
                Direction.WEST,
                Direction.SOUTHEAST,
                Direction.SOUTHWEST,
                Direction.NORTHWEST,
                Direction.NORTHEAST
        });
    }
}
