public class ConsoleInput {

    public static boolean  MakeAction(String direction, GameBoard board)
    {
        boolean action=false;
        switch (direction){
            case "w":
                moveUp(board);
                mergeUp(board);
                moveUp(board);
                action=true;
                break;
            case "a":
                moveLeft(board);
                mergeLeft(board);
                moveLeft(board);
                action=true;
                break;
            case "s":
                moveDown(board);
                mergeDown(board);
                moveDown(board);
                action=true;
                break;
            case "d":
                moveRight(board);
                mergeRight(board);
                moveRight(board);
                action=true;
                break;
            case "q":
                System.out.println("Exiting the game...");
                System.exit(0);
                break;
            default :
                System.out.println("Unrecognized input. Please use only w,a,s,d,q keys...");
        }
        return action;

    }
    public static void moveUp (GameBoard board){
        int [][] array=board.getBoard();
        for (int k=0; k<3; k++){
            for (int i=1; i<4; i++)
            {
                for (int j=0; j<4; j++)
                {
                    if(array[i-1][j]==0)
                    {
                        board.addTile(i-1,j,array[i][j]);
                        board.addTile(i,j,0);
                        array=board.getBoard();
                    }
                }
            }
        }

    }
    public static void moveLeft (GameBoard board) {
        int [][] array=board.getBoard();
        for (int k=0; k<3; k++){
            for (int i=0; i<4; i++)
            {
                for (int j=1; j<4; j++)
                {
                    if(array[i][j-1]==0)
                    {
                        board.addTile(i,j-1,array[i][j]);
                        board.addTile(i,j,0);
                        array=board.getBoard();
                    }
                }
            }
        }

    }
    public static void moveDown (GameBoard board){
        int [][] array=board.getBoard();
        for (int k=0; k<3; k++){
            for (int i=2; i>=0; i--)
            {
                for (int j=0; j<4; j++)
                {
                    if(array[i+1][j]==0)
                    {
                        board.addTile(i+1,j,array[i][j]);
                        board.addTile(i,j,0);
                        array=board.getBoard();
                    }
                }
            }
        }

    }
    public static void moveRight (GameBoard board){
        int [][] array=board.getBoard();
        for (int k=0; k<3; k++){
            for (int i=3; i>=0; i--)
            {
                for (int j=2; j>=0; j--)
                {
                    if(array[i][j+1]==0)
                    {
                        board.addTile(i,j+1,array[i][j]);
                        board.addTile(i,j,0);
                        array=board.getBoard();
                    }
                }
            }
        }

    }

    public static void mergeUp(GameBoard board) {
        int [][] array=board.getBoard();
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<4; j++)
            {
                if(array[i][j]==array[i+1][j])
                {
                    board.addTile(i,j,array[i][j]*2);
                    board.addTile(i+1,j,0);
                    array=board.getBoard();
                }
            }
        }
    }
    public static void mergeLeft(GameBoard board) {
        int [][] array=board.getBoard();
        for (int i=0; i<4; i++)
        {
            for (int j=0; j<3; j++)
            {
                if(array[i][j]==array[i][j+1])
                {
                    board.addTile(i,j,array[i][j]*2);
                    board.addTile(i,j+1,0);
                    array=board.getBoard();
                }
            }
        }
    }
    public static void mergeDown(GameBoard board) {
        int [][] array=board.getBoard();
        for (int i=3; i>=1; i--)
        {
            for (int j=3; j>=0; j--)
            {
                if(array[i][j]==array[i-1][j])
                {
                    board.addTile(i,j,array[i][j]*2);
                    board.addTile(i-1,j,0);
                    array=board.getBoard();
                }
            }
        }
    }
    public static void mergeRight(GameBoard board) {
        int [][] array=board.getBoard();
        for (int i=0; i<4; i++)
        {
            for (int j=3; j>=1; j--)
            {
                if(array[i][j]==array[i][j-1])
                {
                    board.addTile(i,j,array[i][j]*2);
                    board.addTile(i,j-1,0);
                    array=board.getBoard();
                }
            }
        }
    }



}
