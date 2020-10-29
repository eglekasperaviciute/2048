import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameRules rules= new GameRules();
        ConsoleInput input=new ConsoleInput();

        int MaxValue=0;
        int goalValue=2048;
        boolean freeSpaces=true;
        boolean gameOver=false;
        boolean madeAction=false;

        GameBoard board =new GameBoard();
        rules.spawn(board);
        rules.spawn(board);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Controls:\t");
        System.out.print("\tw - up\n" +
                "\ta - left\n" +
                "\ts - down\n" +
                "\td - right\n" +
                "\tq - exit the program\n"+
                "Reach a tile of value "+goalValue+"\n"
        );
        while (gameOver==false)
        {
            board.printBoard(board);

            System.out.println("Waiting for input...");
            String direction=scanner.next();

            madeAction=ConsoleInput.MakeAction(direction,board);
            freeSpaces=rules.freeSpaces(board);

            if (freeSpaces==true &&madeAction==true)
            {
                rules.spawn(board);
                gameOver=rules.gameOver(board);
            }

            //Checking the game over conditions
            if (gameOver==true)
            {
                System.out.println("---GAME OVER---");
                board.printBoard(board);
                return ;
            }
            MaxValue=board.HighestNumber(board);
            if (MaxValue==goalValue)
            {
                System.out.println("------Victory!-----");
                System.out.println("You reached the goal of: "+goalValue+" points");
                gameOver=true;
                return ;
            }
        }
    }
}
