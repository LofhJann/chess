package chess.engine.board;

import chess.engine.piece.Piece;

/**
 * UnmakeMoveInfo is used to unmake moves and contains various information of board state before move
 */
public class UnmakeMoveInfo {

    private Piece movingPiece;
    private Piece capturedPiece;
    private Move move;
    private Piece promotedPiece;

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

    public Piece getPromotedPiece() {
        return promotedPiece;
    }

    public void setPromotedPiece(Piece promotedPiece) {
        this.promotedPiece = promotedPiece;
    }
}
