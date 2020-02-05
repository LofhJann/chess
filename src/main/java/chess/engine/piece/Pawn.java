package chess.engine.piece;

import chess.engine.Color;
import chess.engine.Direction;

public class Pawn extends Piece {
    private boolean firstMove;

    private boolean enpassant = false; // TODO: Implement, or move?

    public Pawn(Color color) {
        super('P', new Direction[]{Direction.NORTH}, color, 10);
        firstMove = true;
    }

    @Override
    public boolean isLegalDirection(int targetSquare) {
        return (targetSquare == Direction.NORTH.intValue)
                || (firstMove && targetSquare == Direction.NORTH.intValue * 2);
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
}
