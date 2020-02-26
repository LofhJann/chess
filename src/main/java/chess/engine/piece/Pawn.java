package chess.engine.piece;

public class Pawn extends Piece {
    private static final int[] EVAL_ARRAY = {
            0, 0, 0, 0, 0, 0, 0, 0,
            50, 50, 50, 50, 50, 50, 50, 50,
            10, 10, 20, 30, 30, 20, 10, 10,
            5, 5, 10, 25, 25, 10, 5, 5,
            0, 0, 0, 20, 20, 0, 0, 0,
            5, -5, -10, 0, 0, -10, -5, 5,
            5, 10, 10, -20, -20, 10, 10, 5,
            0, 0, 0, 0, 0, 0, 0, 0
    };

    public static final Direction[] directions ={Direction.NORTH};
    private boolean firstMove;

    private boolean enpassant = false; // TODO: Implement, or move?

    public Pawn(Color color) {
        super('P', directions, color, 10);
        firstMove = true;
    }

    public Pawn(Color color, int position) {
        super('P', directions, color, 10, position);
        firstMove = true;
    }

    @Override
    public boolean isPseudoLegalMove(int targetSquare) {
        return (targetSquare == Direction.NORTH.intValue)
                || (firstMove && targetSquare == Direction.NORTH.intValue * 2);
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
}
