import game.GameBoard;
import game.GameRules;
import org.junit.Assert;
import org.junit.Test;

public class RulesTests {
    @Test
    public void checkMergeWithAllDifferentTiles() {
        GameBoard board = new GameBoard(2);
        board.addTile(0, 0, 2);
        board.addTile(1, 1, 16);
        board.addTile(0, 1, 4);
        board.addTile(1, 0, 8);
        GameRules rules = new GameRules(board);
        boolean canMerge = rules.canMerge();
        Assert.assertFalse(canMerge);
    }
    @Test
    public void checkEmptyTiles() {
        GameBoard board = new GameBoard(4);
        for (int i = 0; i < board.getBoard().length; i++) for (int j = 0; j < board.getBoard().length; j++) board.addTile(i, j, 2);
        GameRules rules = new GameRules(board);
        boolean freeTiles = rules.freeSpaces();
        Assert.assertFalse(freeTiles);
    }
}
