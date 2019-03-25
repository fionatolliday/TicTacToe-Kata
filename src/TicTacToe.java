import java.util.Scanner;


public class TicTacToe {
    public static void main (String[] args){

//    Welcome message
        System.out.println("Welcome to Tic Tac Toe!");

//    Display current board
        System.out.println("Here's the current board:");
        Board gameBoard = new Board();
        gameBoard.printBoard();

        int playedGames = 0;

        // game loop start
        Player currentPlayer = choosePlayer(playedGames);
        Scanner userInput = new Scanner(System.in);

        while (playedGames < 10) {

            //give game instructions
            //readUserInput
            //check for q - to exit game
            // check that its a valid coordinate (i.e. not a name, or outside the numbers avail)
            //check if valid coordinates are "."
            // add to the board if "."
            //send success message OR send try again message
            //display updated board OR readUserInput again
            //increase played games


            // give instructions
            System.out.println(choosePlayer(playedGames).getName() + " enter a coordinate x,y to" +  " " + "place your " + choosePlayer(playedGames).getPlayerPiece() + " or enter 'q' to give " + "up:");

            // read user input
            String readUserInput = userInput.nextLine();

            if ( readUserInput.equals("q")) {
                System.exit(0);
                userInput.close();
            }

            String[] coordinates = readUserInput.split(",");
            int firstCoordinate = Integer.parseInt(coordinates[0]);
            int secondCoordinate = Integer.parseInt(coordinates[1]);

            String[][] currentArray = gameBoard.getArray();
            // check if user coordinates on board are empty

             if (currentArray[firstCoordinate][secondCoordinate] == "." ) {
                 //play the move
                 currentArray[firstCoordinate][secondCoordinate] =
                         choosePlayer(playedGames).getPlayerPiece();

                 System.out.println("Move accepted, here's the current board: ");

                 gameBoard.printBoard();

                 String currentPlayerToken = choosePlayer(playedGames).getPlayerPiece();

                 if (winCheck(currentArray)){
                     System.out.println("Move accepted, well done you've won the game! ");
                 }

                 // increase playedGames
                 playedGames++;


//                 here is checking lines to see if there is a winning game
//                    String currentPlayerToken = choosePlayer(playedGames).getPlayerPiece();
//                    if ((currentArray[0][0].equals(currentPlayerToken)) && (currentArray[0][1].equals(currentPlayerToken)) && (currentArray[0][2].equals(currentPlayerToken))) {
//                     System.out.println("Move accepted, well done you've won the game!");
//                        System.exit(0);
//                 } else if ((currentArray[1][0].equals(currentPlayerToken)) && (currentArray[1][1].equals(currentPlayerToken)) && (currentArray[1][2].equals(currentPlayerToken))) {
//                        System.out.println("Move accepted, well done you've won the game!");
//                        System.exit(0);
//                    } else if ((currentArray[2][0].equals(currentPlayerToken)) && (currentArray[2][1].equals(currentPlayerToken)) && (currentArray[2][2].equals(currentPlayerToken))) {
//                     System.out.println("Move accepted, well done you've won the game!");
//                        System.exit(0);
//                 }



//                    this is if there is not a vacant spot for the piece
            } else if (currentArray[firstCoordinate][secondCoordinate] == "X"){
                System.out.print("Oh no, a piece is already at this place! Try again...");


            } else if (currentArray[firstCoordinate][secondCoordinate] == "0"){
                System.out.print("Oh no, a piece is already at this place! Try again...");
            }


        }

//        check for a win






        // game loop end

    }



    public static Boolean winCheck(String[][] currentBoardArray) {
        for (int indexOuter = 0; indexOuter < currentBoardArray.length; indexOuter++){
                 if (isWon(currentBoardArray[indexOuter])) {
                     return true;
                 }

            } return false;
        }



//        //check row 0
//        String[] row0 = {currentBoardArray[0][0], currentBoardArray[0][1], currentBoardArray[0][2]};
//        if (isWon(row0)) {
//            return true;
//        }
//
//        // check row 1
//        String[] row1 = {currentBoardArray[1][0], currentBoardArray[1][1], currentBoardArray[1][2]};
//        if (isWon(row1)) {
//            return true;
//        }
//
//        // check row 2
//        String[] row2 = {currentBoardArray[2][0], currentBoardArray[2][1], currentBoardArray[2][2]};
//        if (isWon(row2)) {
//            return true;
//        }
//
//        // check diagonal left to right
//        String[] diagonalLtoR = {currentBoardArray[0][0], currentBoardArray[1][1],
//                currentBoardArray[2][2]};
//        if (isWon(diagonalLtoR)) {
//            return true;
//        }
//        return true;
//    }



    public static Boolean isWon (String[] currentArray){
        String firstChar = currentArray[0];

        if (firstChar == "."){
            return false;
        } else if (firstChar == "X" || firstChar == "0"){
            for (int index = 0; index < currentArray.length; index ++) {
                if (firstChar != currentArray[index]){
                    return false;
                }
            }

        } return true;
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