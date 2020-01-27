package chess.bot;

import chess.engine.GameState;

/**
 * Interface for implementations of chess bots
 */
public interface ChessBot {
    /**
     * @param gamestate GameState
     * @return UCI formatted String of move
     * @see <a href="https://en.wikipedia.org/wiki/Universal_Chess_Interface">https://en.wikipedia.org/wiki/Universal_Chess_Interface</a>
     */
    String nextMove(GameState gamestate);
}
