package game;

import static game.ConsoleOutput.printExitMessage;
import static game.ConsoleOutput.printUnrecognizedInputException;
import static game.Constants.*;
import static game.Constants.emptyTile;

public class ConsoleInput {
    private final GameBoard board;
    public ConsoleInput(GameBoard board) {
        this.board = board;
    }
    public boolean MakeAction(String direction) {
        boolean action = false;
        switch (direction) {
            case up -> {
                moveUp();
                mergeUp();
                action = true;
            }
            case left -> {
                moveLeft();
                mergeLeft();
                action = true;
            }
            case down -> {
                moveDown();
                mergeDown();
                action = true;
            }
            case right -> {
                moveRight();
                mergeRight();
                action = true;
            }
            case quit -> {
                printExitMessage();
                System.exit(0);
            }
            default -> printUnrecognizedInputException();
        }
        return action;
    }
    private void moveUp() {
        for (int k = 0; k < board.getBoard().length - 1; k++) {
            for (int i = 1; i < board.getBoard().length; i++) {
                for (int j = 0; j < board.getBoard().length; j++) {
                    if(board.isAvailable(i-1, j)) {
                        board.addTile(i-1,j, board.getTile(i, j));
                        board.addTile(i, j, emptyTile);
                    }
                }
            }
        }
    }
    private void moveLeft() {
        for (int k = 0; k < board.getBoard().length - 1; k++) {
            for (int i = 0; i < board.getBoard().length; i++) {
                for (int j = 1; j < board.getBoard().length; j++) {
                    if (board.isAvailable(i, j-1)) {
                        board.addTile(i,j-1, board.getTile(i, j));
                        board.addTile(i, j,emptyTile);
                    }
                }
            }
        }
    }
    private void moveDown() {
        for (int k = 0; k < board.getBoard().length - 1; k++) {
            for (int i = board.getBoard().length / 2; i >= 0; i--) {
                for (int j = 0; j < board.getBoard().length; j++) {
                    if(board.isAvailable(i+1, j)) {
                        board.addTile(i+1, j, board.getTile(i, j));
                        board.addTile(i, j, emptyTile);
                    }
                }
            }
        }
    }
    private void moveRight() {
        for (int k = 0; k < board.getBoard().length - 1; k++){
            for (int i = board.getBoard().length - 1; i >= 0; i--) {
                for (int j = board.getBoard().length/2; j >= 0; j--) {
                    if(board.isAvailable(i, j+1)) {
                        board.addTile(i,j+1, board.getTile(i, j));
                        board.addTile(i, j, emptyTile);
                    }
                }
            }
        }
    }
    private void mergeUp() {
        for (int i = 0; i < board.getBoard().length - 1; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                if(board.getTile(i, j) == board.getTile(i+1, j)) {
                    board.addTile(i,j, board.getTile(i, j)*2);
                    board.addTile(i+1,j,emptyTile);
                }
            }
        }
        moveUp();
    }
    private void mergeLeft() {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length - 1; j++) {
                if(board.getTile(i, j) == board.getTile(i, j+1)) {
                    board.addTile(i,j, board.getTile(i, j) * 2);
                    board.addTile(i,j+1, emptyTile);
                }
            }
        }
        moveLeft();
    }
    private void mergeDown() {
        for (int i = board.getBoard().length - 1; i >= 1; i--) {
            for (int j = board.getBoard().length - 1; j >= 0; j--) {
                if(board.getTile(i, j) == board.getTile(i-1, j)) {
                    board.addTile(i, j,board.getTile(i, j) * 2);
                    board.addTile(i-1,j,emptyTile);
                }
            }
        }
        moveDown();
    }
    private void mergeRight() {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = board.getBoard().length - 1; j >= 1; j--) {
                if(board.getTile(i, j) == board.getTile(i, j-1)) {
                    board.addTile(i,j,board.getTile(i, j) * 2);
                    board.addTile(i,j-1, emptyTile);
                }
            }
        }
        moveRight();
    }
}
