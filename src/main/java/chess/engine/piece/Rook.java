package chess.engine.piece;

import chess.engine.Color;
import chess.engine.Direction;

public class Rook extends Piece{
    public Rook(Color color) {
        super('R', new Direction[]{Direction.NORTH,
                Direction.SOUTH,
                Direction.EAST,
                Direction.WEST
        }, color, 50);
    }
}
