package chess.engine.board;

import chess.engine.piece.*;
import data.ArrayList;

import java.util.Stack;

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

    private Color playerInTurn = Color.WHITE;

    public Color getPlayerInTurn() {
        return playerInTurn;
    }

    private Stack<UnmakeMoveInfo> memorizedPositions = new Stack<>();

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
     * @return Current value of position on board
     */
    public int evaluatePosition() {
        int sum = 0;

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
        blackPieces = new ArrayList<>();
        whitePieces = new ArrayList<>();

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

    /**
     * Add piece to list with board index given
     * @param pieceSymbol Symbol of piece
     * @param boardIndex Position on board
     */
    private void addPieceToList(char pieceSymbol, int boardIndex) {
        switch (pieceSymbol) {
            case 'P':
                blackPieces.add(new Pawn(Color.BLACK, boardIndex));
                break;
            case 'p':
                whitePieces.add(new Pawn(Color.WHITE, boardIndex));
                break;
            case 'N':
                blackPieces.add(new Knight(Color.BLACK, boardIndex));
                break;
            case 'n':
                whitePieces.add(new Knight(Color.WHITE, boardIndex));
                break;
            case 'B':
                blackPieces.add(new Bishop(Color.BLACK, boardIndex));
                break;
            case 'b':
                whitePieces.add(new Bishop(Color.WHITE, boardIndex));
                break;
            case 'R':
                blackPieces.add(new Rook(Color.BLACK, boardIndex));
                break;
            case 'r':
                whitePieces.add(new Rook(Color.WHITE, boardIndex));
                break;
            case 'Q':
                blackPieces.add(new Queen(Color.BLACK, boardIndex));
                break;
            case 'q':
                whitePieces.add(new Queen(Color.WHITE, boardIndex));
                break;
            case 'K':
                blackPieces.add(new King(Color.BLACK, boardIndex));
                break;
            case 'k':
                whitePieces.add(new King(Color.WHITE, boardIndex));
                break;
            default:
                break;
        }
    }

    /**
     * Updates state of board with legal move that was done
     *
     * @param legalMove Last legal move done
     */
    public void updateBoardAfterMove(Move legalMove) {
        makeMove(legalMove, true);
        playerInTurn = playerInTurn == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    /**
     * @return ArrayList of pieces of player currently not in turn
     */
    private ArrayList<Piece> getOpposingPlayerPieces() {
        if (playerInTurn == Color.WHITE) {
            return blackPieces;
        } else if (playerInTurn == Color.BLACK) {
            return whitePieces;
        }

        throw new IllegalStateException();
    }

    /**
     * @return ArrayList of pieces of player currently in turn
     */
    private ArrayList<Piece> getOwnPieces() {
        if (playerInTurn == Color.WHITE) {
            return whitePieces;
        } else if (playerInTurn == Color.BLACK) {
            return blackPieces;
        }

        throw new IllegalStateException();
    }

    /**
     * Make move on board
     * @param move Move to make
     * @param isPermanent Used to determine if UnMakeMoveInfo should be saved in History
     */
    private void makeMove(Move move, boolean isPermanent) {
        UnmakeMoveInfo unmakeMoveInfo = new UnmakeMoveInfo(move);

        Piece ownPiece = null;

        for (Piece piece : getOwnPieces()) {
            if (piece.getPosition() == move.getStartingSquare().getIntValue()) {
                ownPiece = piece;
                unmakeMoveInfo.setMovingPiece(ownPiece);
                break;
            }
        }

        ArrayList<Piece> toRemove = new ArrayList<>();
        for (Piece piece : getOpposingPlayerPieces()) {
            if (piece.getPosition() == move.getEndSquare().getIntValue()) {
                toRemove.add(piece);
                unmakeMoveInfo.setCapturedPiece(piece);
                break;
            }
        }
        getOpposingPlayerPieces().removeAll(toRemove);

        boardState[move.getStartingSquare().getIntValue()] = '\u0000';
        if (ownPiece != null) {
            ownPiece.setPosition(move.getEndSquare().getIntValue());
            boardState[move.getEndSquare().getIntValue()] = ownPiece.getPieceSymbol();
        }

        if (!isPermanent) {
            memorizedPositions.push(unmakeMoveInfo);
        }

        playerInTurn = playerInTurn == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    /**
     * Make move that is not permanent
     * @param move Move to make
     */
    public void makeMove(Move move) {
        makeMove(move, false);
    }

    /**
     * Restore previous move from history
     */
    public void unmakeMove() {
        playerInTurn = playerInTurn == Color.WHITE ? Color.BLACK : Color.WHITE;

        UnmakeMoveInfo unmakeMoveInfo = memorizedPositions.pop();

        Move move = unmakeMoveInfo.getMove();

        Piece ownPiece = unmakeMoveInfo.getMovingPiece();

        int startingSquareIndex = move.getStartingSquare().getIntValue();
        int endSquareIndex = move.getEndSquare().getIntValue();

        if (unmakeMoveInfo.getCapturedPiece() != null) {
            Piece capturedPiece = unmakeMoveInfo.getCapturedPiece();
            boardState[endSquareIndex] = capturedPiece.getPieceSymbol();
            getOpposingPlayerPieces().add(capturedPiece);
        } else {
            boardState[endSquareIndex] = '\u0000';
        }

        ownPiece.setPosition(startingSquareIndex);
        boardState[startingSquareIndex] = ownPiece.getPieceSymbol();

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

    /**
     * Get piece symbol of piece in square
     * @param squareIndex Index of square
     * @return Symbol of piece in square
     */
    public char getSquareContents(int squareIndex) {
        if (squareIndex > boardState.length - 1 || squareIndex < 0) {
            throw new IllegalSquareIndexException();
        }
        return boardState[squareIndex];
    }

    /**
     *
     * @param squareIndex Index of square
     * @return Boolean whether parameter square is empty or not
     */
    public boolean squareIsEmpty(int squareIndex) {
        if (squareIndex > boardState.length - 1 || squareIndex < 0) {
            throw new IllegalSquareIndexException();
        }

        return boardState[squareIndex] == '\u0000';
    }

    /**
     * Get color of piece on square
     * @param squareIndex Index of square on board
     * @return Color of piece on parameter square
     */
    public Color getSquarePieceColor(int squareIndex) {
        if (squareIndex > boardState.length - 1 || squareIndex < 0) {
            throw new IllegalSquareIndexException();
        }

        if (squareIsEmpty(squareIndex)) {
            return null;
        }

        boolean lowerCase = Character.isLowerCase(getSquareContents(squareIndex));
        if (lowerCase) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    public ArrayList<Piece> getBlackPieces() {
        return blackPieces;
    }

    public ArrayList<Piece> getWhitePieces() {
        return whitePieces;
    }

    /**
     * @return FEN formatted String of current position on Board
     */
    @Override
    public String toString() {
        StringBuilder fenString = new StringBuilder();
        int emptySquareCount = 0;

        for (int boardIndex = 0; boardIndex < boardState.length; boardIndex++) {
            if ((boardIndex & 0x88) == 0) {
                if (boardState[boardIndex] == '\u0000') {
                    emptySquareCount++;
                } else {
                    if (emptySquareCount > 0) {
                        fenString.append(emptySquareCount);
                        emptySquareCount = 0;
                    }
                    fenString.append(boardState[boardIndex]);
                }
            } else {
                if (emptySquareCount != 0) {
                    fenString.append(emptySquareCount);
                    emptySquareCount = 0;
                }
                fenString.append("/");
                while ((boardIndex + 1 & 0x88) != 0) {
                    boardIndex++;
                }
            }
        }
        fenString.deleteCharAt(fenString.length() - 1);
        return fenString.toString();
    }
}
