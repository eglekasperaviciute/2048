package game;

import static game.Constants.goalValue;

public class ConsoleOutput {
    public static void printControls() {
        System.out.println("Controls:\t");
        System.out.print("\tw - up\n" +
                "\ta - left\n" +
                "\ts - down\n" +
                "\td - right\n" +
                "\tq - exit the program\n"+
                "Reach a tile of value " + goalValue + "\n"
        );
    }
    public void printGameWon() {
        System.out.println("------Victory!-----");
        System.out.println("You reached the goal of: " + goalValue + " points");
    }
    public void printBoard(GameBoard board){
        printLine();
        for (int i = 0; i < board.getBoard().length; i++){
            for (int j = 0; j < board.getBoard().length + 2; j++) {
                if (j == 0 || j == board.getBoard().length + 1) System.out.print("|");
                else {
                    if (board.isAvailable(i, j - 1)) System.out.print("[ ]");
                    else System.out.print("[" + board.getTile(i, j - 1) + "]");
                }
                if (j == board.getBoard().length + 1) System.out.println();
            }
        }
        printLine();
    }
    public void printGameOver(GameBoard board) {
        System.out.println("---GAME OVER---");
        printBoard(board);
    }
    public void printWaiting() {
        System.out.println("Waiting for input...");
    }
    public static void printUnrecognizedInputException() {
        System.out.println("Unrecognized input. Please use only w,a,s,d,q keys...");
    }
    public static void printExitMessage() {
        System.out.println("Exiting the game...");
    }
    private void printLine() {
        System.out.println("---------------");
    }
}
