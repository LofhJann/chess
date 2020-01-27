package chess.engine;

import data.Pair;

public class Move extends Pair<String> {

    private String startingSquare;
    private String endSquare;

    public Move(String startingSquare, String endSquare) {
        super(startingSquare, endSquare);
    }

    public String getStartingSquare() {
        return startingSquare;
    }

    public void setStartingSquare(String startingSquare) {
        this.startingSquare = startingSquare;
    }

    public String getEndSquare() {
        return endSquare;
    }

    public void setEndSquare(String endSquare) {
        this.endSquare = endSquare;
    }

    @Override
    public String toString() {
        return startingSquare + endSquare;
    }
}
