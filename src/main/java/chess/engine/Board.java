package chess.engine;

import chess.engine.piece.*;

public class Board {

    private char[] bitBoard = new char[128];
    private Piece[] blackPieces = new Piece[]{new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(),
            new Pawn(), new Pawn(), new Rook(), new Rook(), new Bishop(), new Bishop(), new Queen(), new King(), new Knight(), new Knight()
    };
    private Piece[] whitePieces = new Piece[]{new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(),
            new Pawn(), new Pawn(), new Rook(), new Rook(), new Bishop(), new Bishop(), new Queen(), new King(), new Knight(), new Knight()
    };
}
