package game;

import static game.Constants.emptyTile;

public class GameBoard {
    private final Tile[][] board;
    public GameBoard(int size) {
        board = new Tile[size][size];
        for (int i = 0; i < size; i++) for (int j = 0; j < size; j++) board[i][j] = new Tile(emptyTile);
    }
    public Tile[][] getBoard() {
        return board;
    }
    public int getTile(int x, int y) {
        return board[x][y].getValue();
    }
    public boolean isAvailable(int x, int y) {
        return board[x][y].getValue() == emptyTile;
    }
    public void addTile(int x, int y, int value){
        board[x][y].setValue(value);
    }
    public int HighestNumber(GameBoard board) {
        int highestNum = 0;
        for (int i = 0; i < board.getBoard().length; i++)
            for (int j = 0; j < board.getBoard().length; j++)
                if (board.getTile(i, j) > highestNum) highestNum = board.getTile(i, j);
        return highestNum;
    }
}
