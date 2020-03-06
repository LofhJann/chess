package chess.bot;

import chess.bot.MyDefaultLibraryBot;
import chess.engine.GameState;
import org.junit.Test;

import static chess.model.Testdata.gameStateFullJson;

@Deprecated
public class MyDefaultLibraryBotTest {

    //TODO: Add some real tests.

    @Test
    public void testNextMove() {
        GameState gameState = GameState.parseFromJson(gameStateFullJson);
        MyDefaultLibraryBot myDefaultLibraryBot = new MyDefaultLibraryBot();

        myDefaultLibraryBot.nextMove(gameState);
    }
}
