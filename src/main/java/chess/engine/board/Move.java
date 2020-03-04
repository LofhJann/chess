package chess.engine.board;

public class Move {

    private Square startingSquare;
    private Square endSquare;
    private String promotion;

    public Move(Square startingSquare, Square endSquare) {
        this.startingSquare = startingSquare;
        this.endSquare = endSquare;
    }

    public Move(String moveString) {
        this.startingSquare = Square.valueOf(moveString.substring(0, 2));
        this.endSquare = Square.valueOf(moveString.substring(2, 4));
        this.promotion = moveString.substring(4);
    }

    public Move(Square startingSquare, Square endSquare, String promotion) {
        this.startingSquare = startingSquare;
        this.endSquare = endSquare;
        this.promotion = promotion;

    }

    public Square getStartingSquare() {
        return startingSquare;
    }

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
        return startingSquare.name() + endSquare.name() + (this.promotion != null ? this.promotion : "");
    }
}
