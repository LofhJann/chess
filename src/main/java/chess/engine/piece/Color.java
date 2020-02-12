package chess.engine.piece;

public enum Color {
    WHITE(1), BLACK(-1);

    private int intValue;

    Color(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return this.intValue;
    }
}
