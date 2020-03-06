package chess.engine.piece;

import chess.engine.board.Square;

public class Pawn extends Piece {

    /**
     * Array for position based evaluation for piece
     */
    public static final int[] EVAL_ARRAY = {
            0, 0, 0, 0, 0, 0, 0, 0,
            50, 50, 50, 50, 50, 50, 50, 50,
            10, 10, 20, 30, 30, 20, 10, 10,
            5, 5, 10, 25, 25, 10, 5, 5,
            0, 0, 0, 20, 20, 0, 0, 0,
            5, -5, -10, 0, 0, -10, -5, 5,
            5, 10, 10, -20, -20, 10, 10, 5,
            0, 0, 0, 0, 0, 0, 0, 0
    };

    /**
     * Directions where Piece can move
     */
    private static final Direction[] directions = new Direction[1];

    public Pawn(Color color) {
        super('P', directions, color, 10);
    }

    public Pawn(Color color, int position) {
        super('P', directions, color, 10, position);
        if (color == Color.WHITE) {
            directions[0] = Direction.NORTH;
        } else {
            directions[0] = Direction.SOUTH;
        }
    }

    /**
     * Checks if Pawn is on starting rank to determine if it hasn't moved yet
     * @return Boolean whether Pawn has moved yet
     */
    public boolean isFirstMove() {
        return (getColor() == Color.WHITE && getPosition() <= Square.H2.getIntValue() && getPosition() >= Square.A2.getIntValue())
                || (getColor() == Color.BLACK && getPosition() <= Square.H7.getIntValue() && getPosition() >= Square.A7.getIntValue());
    }

    /**
     * Checks if in theory Pawn could move in given square
     * @param targetSquare square to move to
     * @return Boolean if move is possible, given it's not blocked by other pieces
     */
    @Override
    public boolean isPseudoLegalMove(int targetSquare) {
        if (getColor() == Color.WHITE) {
            return (targetSquare == getPosition() + Direction.NORTH.intValue)
                    || (isFirstMove() && targetSquare == getPosition() + Direction.NORTH.intValue * 2);
        } else {
            return (targetSquare == getPosition() + Direction.SOUTH.intValue)
                    || (isFirstMove() && targetSquare == getPosition() + Direction.SOUTH.intValue * 2);
        }
    }

    @Override
    public boolean isPseudoLegalMove(int targetSquare, Direction direction) {
        return isPseudoLegalMove(targetSquare);
    }

    @Override
    public Direction[] getMoveDirections() {
        return getColor() == Color.WHITE ? new Direction[]{Direction.NORTH} : new Direction[]{Direction.SOUTH};
    }
}
