package chess.engine.board;

import chess.engine.piece.Piece;

public class UnmakeMoveInfo {

    private Piece movingPiece;
    private Piece capturedPiece;
    private Move move;

    public UnmakeMoveInfo(Move move) {
        this.move = move;
    }

    public Piece getMovingPiece() {
        return movingPiece;
    }

    public void setMovingPiece(Piece movingPiece) {
        this.movingPiece = movingPiece;
    }

    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    public void setCapturedPiece(Piece capturedPiece) {
        this.capturedPiece = capturedPiece;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
