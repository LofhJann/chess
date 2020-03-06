package chess.bot;

import chess.engine.GameState;
import org.junit.Test;

import static chess.model.Testdata.gameStateFullJson;

public class MyChessLibBotTest {

    //TODO: Add some real tests.

    @Test
    public void testNextMove() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        MyChessLibBot myChessLibBot = new MyChessLibBot();

        myChessLibBot.nextMove(gameState);
    }
}
