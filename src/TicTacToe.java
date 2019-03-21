import java.util.Scanner;


public class TicTacToe {



    public static void main (String[] args){

//    Welcome message
        System.out.println("Welcome to Tic Tac Toe!");

//    Display current board
        System.out.println("Here's the current board:");
        Board gameBoard = new Board();
        gameBoard.printInitialBoard();
        int playedGames = 0;

        // game loop start

        Player currentPlayer = choosePlayer(playedGames);

        Scanner userInput = new Scanner(System.in);

        while (playedGames < 9) {
            //give game instructions
            //readUserInput
            //check for q - to exit game
            // check that its a valid coordinate (i.e. not a name, or outside the numbers avail)
            //check if valid coordinates are "."
            // add to the board if "."
            //send success message OR send try again message
            //display updated board OR readUserInput again
            //increase played games



            // HAPPY PATH
            // give instructions
            System.out.println(currentPlayer.getName() + " enter a coordinate x,y to place your " + currentPlayer.getPlayerPiece() + " or enter 'q' to give up:");

            // read user input
            String readUserInput = userInput.nextLine();

            String[] coordinates = readUserInput.split(",");
            int firstCoordinate = Integer.parseInt(coordinates[0]);
            int secondCoordinate = Integer.parseInt(coordinates[1]);

            String[][] currentBoard = gameBoard.getBoard();
            // check if user coordinates on board are empty


            if ( readUserInput.equals("q")) {
                System.exit(0);
                userInput.close();
            } else if (currentBoard[firstCoordinate][secondCoordinate] == "." ){
                //play the move
                currentBoard[firstCoordinate][secondCoordinate] = currentPlayer.getPlayerPiece();

            } else if (currentBoard[firstCoordinate][secondCoordinate] == "X"){
                System.out.print("Oh no, a piece is already at this place! Try again...");

            } else if (currentBoard[firstCoordinate][secondCoordinate] == "0"){
                System.out.print("Oh no, a piece is already at this place! Try again...");

            }

            // add move to board


            // send success message and updated board
            System.out.println("Move accepted, here's the current board: ");
            System.out.println(currentBoard);
            // increase playedGames
                playedGames++;
        }


        // game loop end

    }




    private static Player choosePlayer(int playedGames) {
        Player currentPlayer;

        if(playedGames % 2 == 0){
            currentPlayer = new Player("Player 1", "X");
        }else{
            currentPlayer = new Player("Player 2", "0");
        }
        return currentPlayer;
    }
}