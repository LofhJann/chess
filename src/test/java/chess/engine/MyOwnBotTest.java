package chess.engine;

import chess.bot.MyOwnBot;
import org.junit.Test;

public class MyOwnBotTest {

    @Test
    public void testBot() {
        GameState gameState = new GameState();
        MyOwnBot myOwnBot = new MyOwnBot();

        myOwnBot.nextMove(gameState);
    }
}
