package chess.engine.piece;

import chess.engine.Direction;

public class Bishop extends Piece {
    public Bishop() {
        super('B', new Direction[]{Direction.NORTHEAST, Direction.NORTHWEST, Direction.SOUTHEAST, Direction.SOUTHWEST});
    }
}
