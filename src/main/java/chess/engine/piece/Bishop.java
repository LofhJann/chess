package chess.engine.piece;

import chess.engine.Color;
import chess.engine.Direction;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super('B', new Direction[]{Direction.NORTHEAST, Direction.NORTHWEST, Direction.SOUTHEAST, Direction.SOUTHWEST }, color, 30);
    }
}
