import game.ConsoleInput;
import game.GameBoard;
import game.GameRules;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static game.Constants.fieldSize;
import static game.Constants.initialTiles;

public class InputTests {
    @Test
    public void printUnrecognizedCommandMessage() {
        GameBoard board = new GameBoard(fieldSize);
        GameRules rules = new GameRules(board);
        ConsoleInput input = new ConsoleInput(board);
        for (int i = 0; i < initialTiles; i++) rules.spawn();
        String command = "x";
        ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        input.MakeAction(command);
        String message = out.toString();
        Assert.assertTrue(message.contains("Unrecognized input. Please use only w,a,s,d,q keys..."));
    }
}
