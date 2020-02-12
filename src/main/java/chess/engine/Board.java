package chess.engine;

import chess.engine.piece.*;
import data.ArrayList;

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
    private char[] boardState = new char[128];

    private ArrayList<Piece> blackPieces = new ArrayList<>();
    private ArrayList<Piece> whitePieces = new ArrayList<>();

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
        setupBoardFromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1\n");

    }

    /**
     * @return 128-bit array representing current state of board
     */
    public char[] getBoardState() {
        return boardState;
    }

    /**
     * @return Current value of pieces on board
     */
    public double evaluatePosition() {
        double sum = 0;

        for (Object piece : blackPieces.getData()) {
            sum += piece == null ? 0 : ((Piece) piece).getValue();
        }
        for (Object piece : whitePieces.getData()) {
            sum += piece == null ? 0 : ((Piece) piece).getValue();
        }

        return sum;
    }


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
                boardState[boardIndex] = fenString.charAt(i);
                addPieceToList(fenString.charAt(i), boardIndex);
                boardIndex++;
            }
        }
    }

    private void addPieceToList(char pieceSymbol, int boardIndex) {
        switch (pieceSymbol) {
            case 'p':
                blackPieces.add(new Pawn(Color.BLACK));
                break;
            case 'P':
                whitePieces.add(new Pawn(Color.WHITE));
                break;
            case 'n':
                blackPieces.add(new Knight(Color.BLACK));
                break;
            case 'N':
                whitePieces.add(new Knight(Color.WHITE));
                break;
            case 'b':
                blackPieces.add(new Bishop(Color.BLACK));
                break;
            case 'B':
                whitePieces.add(new Bishop(Color.WHITE));
                break;
            case 'r':
                blackPieces.add(new Rook(Color.BLACK));
                break;
            case 'R':
                whitePieces.add(new Rook(Color.WHITE));
                break;
            case 'q':
                blackPieces.add(new Queen(Color.BLACK));
                break;
            case 'Q':
                whitePieces.add(new Queen(Color.WHITE));
                break;
            case 'k':
                blackPieces.add(new King(Color.BLACK));
                break;
            case 'K':
                whitePieces.add(new King(Color.WHITE));
                break;
            default:
                break;
        }
    }

    /**
     * Updates state of board with move that was done
     *
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

    public ArrayList<Piece> getBlackPieces() {
        return blackPieces;
    }

    public ArrayList<Piece> getWhitePieces() {
        return whitePieces;
    }
}
