package chess.engine.board;

public class Move{

    private String startingSquare;
    private String endSquare;
    private String promotion;

    public Move(String startingSquare, String endSquare) {
        this.startingSquare = startingSquare;
        this.endSquare = endSquare;
    }

    public Move(String startingSquare, String endSquare, String promotion) {
        this.startingSquare = startingSquare;
        this.endSquare = endSquare;
        this.promotion = promotion;

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
