package chess.engine.piece;

/**
 * Possible movements converted to locations of next square in that direction (current square + direction = target square)
 */
public enum Direction {
    EAST(1),
    WEST(-1),
    NORTHWEST(15),
    SOUTHEAST(-15),
    NORTH(16),
    SOUTH(-16),
    NORTHEAST(17),
    SOUTHWEST(-17),
    KNIGHT_WESTNORTH(14),
    KNIGHT_EASTNORTH(18),
    KNIGHT_WESTSOUTH(-18),
    KNIGHT_EASTSOUTH(-14),
    KNIGHT_NORTHWEST(31),
    KNIGHT_NORTHEAST(33),
    KNIGHT_SOUTHWEST(-33),
    KNIGHT_SOUTHEAST(-31);

    public final int intValue;

    Direction(int intValue) {
        this.intValue = intValue;
    }
}
