package chess.bot;

import chess.bot.MyOwnBot;
import chess.engine.GameState;
import org.junit.Test;

public class MyOwnBotTest {

    @Test
    public void testBot() {
        GameState gameState = new GameState();
        MyOwnBot myOwnBot = new MyOwnBot();

        myOwnBot.nextMove(gameState);
    }
}
