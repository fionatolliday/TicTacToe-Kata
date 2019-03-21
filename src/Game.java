import java.util.Scanner;

public class Game {

    Player player1 = new Player("Player 1", "X");
    Player player2 = new Player("Player 2", "0");




//    construct a new game
    public void Game (String[] args){
        Game newGame = new Game();
    }



//    whose turn is it?
//    start number of plays at 0
     int numOfPlays = 0;

     public String whoseTurn(){
         if (numOfPlays % 2 == 0){
             return player1.getName();
         }
         else{
             return player2.getName();
         }
     }

}
