package chess.engine;

import chess.bot.MyBot;
import org.junit.Ignore;
import org.junit.Test;

import static chess.model.Testdata.gameStateFullJson;

public class MyBotTest {

    //TODO: Add some real tests.

    @Test
    public void testNextMove() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        MyBot myBot = new MyBot();

        myBot.nextMove(gameState);
    }
}
