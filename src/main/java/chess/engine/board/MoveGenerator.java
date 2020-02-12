package chess.engine.board;

import chess.engine.piece.Color;
import chess.engine.piece.Piece;
import data.ArrayList;

public class MoveGenerator {

    public static ArrayList<Move> generateLegalMoves(Board board) {

        return new ArrayList<>();
    }

    private static ArrayList<Move> generatePseudoLegalMoves(Board board, Color currentPlayer) {
        ArrayList<Move> moves = new ArrayList<>();

        generatePawnMoves(board, moves);
        generateBishopMoves(board, moves);
        generateKingMoves(board, moves);
        generateKnightMoves(board, moves);
        generateQueenMoves(board, moves);
        generateRookMoves(board, moves);

        return moves;
    }

    // TODO: enpassant
    private static ArrayList<Move> generatePawnMoves(Board board, ArrayList<Move> moves) {
        return moves;
    }

    private static ArrayList<Move> generatePawnCaptures(Board board, ArrayList<Move> moves) {
        return moves;
    }

    private static ArrayList<Move> generateBishopMoves(Board board, ArrayList<Move> moves) {
        return moves;
    }

    // TODO: Castling
    private static ArrayList<Move> generateKingMoves(Board board, ArrayList<Move> moves) {
        return moves;
    }

    private static ArrayList<Move> generateKnightMoves(Board board, ArrayList<Move> moves) {
        return moves;
    }

    private static ArrayList<Move> generateQueenMoves(Board board, ArrayList<Move> moves) {
        return moves;
    }

    private static ArrayList<Move> generateRookMoves(Board board, ArrayList<Move> moves) {
        return moves;
    }

    private static ArrayList<Piece> getPieceList(Board board, Color color) {
        if (color == Color.BLACK) {
            return board.getBlackPieces();
        } else if (color == Color.WHITE) {
            return board.getWhitePieces();
        }

        throw new IllegalArgumentException("Color must be either black or white!");
    }
}