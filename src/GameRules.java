public class GameRules {
    public GameRules() {
    }

    public void spawn(GameBoard board)
    {
        boolean placed=false;

        while (placed==false)
        {
            int x=(int)(Math.random() * 4);
            int y=(int)(Math.random() * 4);
            if (board.isAvailable(x,y))
            {
                board.addTile(x,y,decideValue());
                placed=true;
            }
            else {continue;}
        }
    }
    public int decideValue (){
        int []  values = new int []{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,4};
        int index=(int)(Math.random() * values.length);
        return values[index];
    }

    public boolean gameOver(GameBoard board){
        boolean merge=canMerge(board);
        boolean spaces=freeSpaces(board);

        if (merge==false && spaces==false)
            return true;
        else
            return false;
    }

    public boolean canMerge(GameBoard board) {
            int values[][]=board.getBoard();
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++) {
                    if (i!=3){
                        if (values[i][j]==values[i+1][j]) {return true;}
                    }
                    if (j!=3)
                    {
                        if (values[i][j]==values[i][j+1]) {return true;}
                    }
                }
            }
            return false;
        }

    public boolean freeSpaces (GameBoard board) {
        int freePlaces=0;
        for (int i=0; i<4; i++)
        {
            for (int j=0; j<4; j++)
            {
                if(board.isAvailable(i,j))
                {
                    freePlaces++;
                }
            }
        }
        if (freePlaces==0)
            return false;
        else
            return true;
    }
}
