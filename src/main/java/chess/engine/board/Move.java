package chess.engine.board;

public class Move {

    private Square startingSquare;
    private Square endSquare;
    private String promotion;

    /**
     * Create Move with given parameters
     * @param startingSquare Square where move starts
     * @param endSquare Square where move ends
     */
    public Move(Square startingSquare, Square endSquare) {
        this.startingSquare = startingSquare;
        this.endSquare = endSquare;
    }

    /**
     * Create Move from given UCI formatted String
     * @param moveString UCI Formatted String
     */
    public Move(String moveString) {
        this.startingSquare = Square.valueOf(moveString.substring(0, 2).toUpperCase());
        this.endSquare = Square.valueOf(moveString.substring(2, 4).toUpperCase());
        this.promotion = moveString.substring(4).toLowerCase();
    }

    public Move(Square startingSquare, Square endSquare, String promotion) {
        this.startingSquare = startingSquare;
        this.endSquare = endSquare;
        this.promotion = promotion;

    }

    /**
     *
     * @return Starting Square
     */
    public Square getStartingSquare() {
        return startingSquare;
    }

    /**
     *
     * @return End Square
     */
    public Square getEndSquare() {
        return endSquare;
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
        return (startingSquare.name() + endSquare.name() + (this.promotion != null ? this.promotion : "")).toLowerCase();
    }
}
