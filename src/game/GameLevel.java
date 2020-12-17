package game;

import java.util.Scanner;
import static game.ConsoleOutput.printControls;
import static game.Constants.fieldSize;
import static game.Constants.initialTiles;

public class GameLevel {
    private static GameLevel level = null;
    private final ConsoleOutput output;
    private final ConsoleInput input;
    private final GameBoard board;
    private final GameRules rules;
    private final Scanner scanner;
    private GameLevel() {
        output = new ConsoleOutput();
        board = new GameBoard(fieldSize);
        rules = new GameRules(board);
        input = new ConsoleInput(board);
        for (int i = 0; i < initialTiles; i++) rules.spawn();
        scanner = new Scanner(System.in);
    }
    public static GameLevel getLevel() {
        if (level == null) level = new GameLevel();
        return level;
    }
    public void playLevel() {
        printControls();
        while (!rules.gameOver() && !rules.gameWon()) {
            output.printBoard(board);
            output.printWaiting();
            String direction = scanner.next();
            boolean madeAction = input.MakeAction(direction);
            boolean freeSpaces = rules.freeSpaces();
            if (freeSpaces && madeAction) rules.spawn();
            if (rules.gameOver()) {
                output.printGameOver(board);
                return;
            }
            if (rules.gameWon()) {
                output.printGameWon();
                return;
            }
        }
    }
}
