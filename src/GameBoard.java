public class GameBoard {

  private int board [][] = new int [][] {
          {0,0,0,0},
          {0,0,0,0},
          {0,0,0,0},
          {0,0,0,0},
  };

  public int[][] getBoard() {
        return board;
    }
    public boolean isAvailable(int x, int y) {
      return board[x][y]==0;
  }
  public void addTile(int x, int y, int value){
      board[x][y]=value;
  }
  public void printBoard(GameBoard board){
      System.out.println("---------------");
      for(int i=0; i<4; i++){
          for (int j=0; j<6; j++) {
              if (j==0 || j==5) {
                  System.out.print("|");
              }
              else {
                  int x=i;
                  int y=j-1;
                  if (board.getBoard()[x][y]==0) {System.out.print("[ ]");}
                  else {System.out.print("["+board.getBoard()[x][y]+"]");}
              }
              if (j==5) { System.out.println();}
          }
      }
      System.out.println("---------------");
  }
  public int HighestNumber(GameBoard board) {
     int max=0;
     int values[][]=board.getBoard();
     for (int i=0; i<4; i++)
     {
         for (int j=0; j<4; j++)
         {
             if (values[i][j]>max)
                 max=values[i][j];
         }
     }
     return max;
  }
}
