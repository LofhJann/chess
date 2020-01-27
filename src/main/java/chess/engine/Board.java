package chess.engine;

import chess.engine.piece.*;

public class Board {

    private char[] board = new char[128];
    private Piece[] blackPieces = new Piece[]{new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(),
            new Pawn(), new Pawn(), new Rook(), new Rook(), new Bishop(), new Bishop(), new Queen(), new King(), new Knight(), new Knight()
    };
    private Piece[] whitePieces = new Piece[]{new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(),
            new Pawn(), new Pawn(), new Rook(), new Rook(), new Bishop(), new Bishop(), new Queen(), new King(), new Knight(), new Knight()
    };

    public Board(String initialFen) {
        setupBoardFromFEN(initialFen);
    }

    public Board() {
    }

    public char[] getBoard() {
        return board;
    }

    // TODO: Check for unallowed methods
    /**
     * Sets up board using given FEN String.
     *
     * @param fenString FEN formatted String of starting position.
     * @see <a href="https://en.wikipedia.org/wiki/Forsyth-Edwards_Notation">https://en.wikipedia.org/wiki/Forsyth-Edwards_Notation</a>
     */
    public void setupBoardFromFEN(String fenString) {
        int boardIndex = 0;

        for (int i = 0; i < fenString.length(); i++) {
            if (boardIndex >= 128 || Character.isWhitespace(fenString.charAt(i))) {
                break;
            }
            while ((boardIndex & 0x88) != 0) {
                boardIndex++;
            }
            if (fenString.charAt(i) == '/') {
                while (boardIndex % 16 != 0) {
                    boardIndex++;
                }
            } else if (Character.isDigit(fenString.charAt(i))) {
                boardIndex += Integer.parseInt("" + fenString.charAt(i));

            } else {
                board[boardIndex] = fenString.charAt(i);
                boardIndex++;
            }
        }
    }

    public void updateBoardAfterMove(Move move) {
        // TODO
    }

    /**
     * Converts given square to index on board array
     *
     * @param square String representation of square on board
     * @return Board index of given square String
     */
    public int squareToBoardIndex(String square) {
        return (square.toLowerCase().charAt(0) - 97) + (Integer.parseInt("" + square.charAt(1)) - 1) * 16;
    }
}
