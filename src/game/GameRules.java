package game;

import static game.Constants.goalValue;

public class GameRules {
    private final GameBoard board;
    public GameRules(GameBoard gameBoard) {
        this.board = gameBoard;
    }
    public void spawn() {
        boolean placed = false;
        while (!placed) {
            int x = (int)(Math.random() * board.getBoard().length);
            int y = (int)(Math.random() * board.getBoard().length);
            if (board.isAvailable(x,y)) {
                board.addTile(x, y, decideValue());
                placed = true;
            }
        }
    }
    private int decideValue() {
        int [] values = new int []{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,4};
        int index=(int)(Math.random() * values.length);
        return values[index];
    }
    public boolean gameOver() {
        boolean merge = canMerge();
        boolean spaces = freeSpaces();
        return !merge && !spaces;
    }
    public boolean canMerge() {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                if (i != board.getBoard().length - 1) if (board.getTile(i,j) == board.getTile(i + 1,j)) return true;
                if (j != board.getBoard().length - 1) if (board.getTile(i,j) == board.getTile(i,j + 1)) return true;
            }
        }
        return false;
    }
    public boolean freeSpaces() {
        int freePlaces = 0;
        for (int i = 0; i < board.getBoard().length; i++)
            for (int j = 0; j < board.getBoard().length; j++)
                if (board.isAvailable(i, j)) freePlaces++;
        return freePlaces != 0;
    }
    public boolean gameWon() {
        return board.HighestNumber(board) == goalValue;
    }
}
