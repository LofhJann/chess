package chess.engine;

import data.Pair;

public class Move extends Pair<String> {

    private String startingSquare;
    private String endSquare;
    private String promotion;

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

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    /**
     * @return UCI formatted representation of Move
     */
    @Override
    public String toString() {
        return startingSquare + endSquare + (this.promotion != null ? this.promotion : "");
    }
}
