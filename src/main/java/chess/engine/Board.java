package chess.engine;

import chess.engine.piece.*;

/**
 * Tracks current state of board
 */
public class Board {

    /**
     * Board represented in 128 bit array (0x88 representation). Character representations of pieces are used.
     *
     * @see <a href="https://www.chessprogramming.org/0x88">https://www.chessprogramming.org/0x88</a>
     * @see <a href="https://1.bp.blogspot.com/_WEXl7U-k4hA/RYGnrJx3m4I/AAAAAAAAAAk/yUlMZh4YLI4/s1600/br%C3%A4demed0x88+kopiera.gif>
     * Photo explanation of 0x88</a>
     */
    private char[] board = new char[128];
    private Piece[] blackPieces = new Piece[]{new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(),
            new Pawn(), new Pawn(), new Rook(), new Rook(), new Bishop(), new Bishop(), new Queen(), new King(), new Knight(), new Knight()
    };
    private Piece[] whitePieces = new Piece[]{new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(),
            new Pawn(), new Pawn(), new Rook(), new Rook(), new Bishop(), new Bishop(), new Queen(), new King(), new Knight(), new Knight()
    };

    /**
     * Create new Board with initial position given
     *
     * @param initialFen FEN formatted String of initial position to setup
     * @see <a href="https://en.wikipedia.org/wiki/Forsyth-Edwards_Notation">https://en.wikipedia.org/wiki/Forsyth-Edwards_Notation</a>
     */
    public Board(String initialFen) {
        setupBoardFromFEN(initialFen);
    }

    /**
     * Create new Board with no position given
     */
    public Board() {
    }

    /**
     *
     * @return 128-bit array representing current state of board
     */
    public char[] getBoard() {
        return board;
    }


    /**
     * Sets up board using given FEN String.
     *
     * @param fenString FEN formatted String of starting position.
     * @see <a href="https://en.wikipedia.org/wiki/Forsyth-Edwards_Notation">https://en.wikipedia.org/wiki/Forsyth-Edwards_Notation</a>
     */
    // TODO: Check for unallowed methods
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

    /**
     * Updates state of board with move that was done
     * @param move Last move done
     */
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
