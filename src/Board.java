import java.util.Arrays;

public class Board {

    private String[][] board;
    public String[][] getArray() {
        return board;
    }



    public Board(){ //why do the websites say we need to have static and void?
        this.board = new String[3][3];//initialized the array and set the size for each array
        for (int x = 0; x < this.board.length; x++){
            for (int y = 0; y < this.board[0].length; y++){
                    this.board[x][y] = ".";
            }
        }
    }




    public void printBoard(){
     for (int i = 0; i < board.length; i++) {

                for (int j = 0; (board[i] != null && j < board[i].length); j++)
                    System.out.print(board[i][j] + " ");

               System.out.println();
            }
    }


}


