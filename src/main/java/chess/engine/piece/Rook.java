package chess.engine.piece;

import chess.engine.Direction;

public class Rook extends Piece{
    public Rook() {
        super('R', new Direction[]{Direction.NORTH,
                Direction.SOUTH,
                Direction.EAST,
                Direction.WEST
        });
    }
}
