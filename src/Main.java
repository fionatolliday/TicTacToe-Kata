import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

//      Welcome message
        System.out.println("Welcome to Tic Tac Toe!");
//
////    Display current board
        System.out.println("Here's the current board:");
        Board gameBoard = new Board();
        gameBoard.printBoard();
        Scanner userInput = new Scanner(System.in);
//
////    Start games at zero in order to interchange the player
        int playedGames = 0;
//
//        // Game loop start
        while (playedGames < 10) {
//
//            // Give instructions
            System.out.println(TicTacToe.choosePlayer(playedGames).getName() + " enter a coordinate " +
                    "x,y to" + " " + "place your " + TicTacToe.choosePlayer(playedGames).getPlayerPiece() + " or enter 'q' to give " + "up:");
//
//            // Read user input
            String readUserInput = userInput.nextLine();

            if (readUserInput.equals("q")) {
                System.exit(0);
                userInput.close();
            }

            String[] coordinates = readUserInput.split(",");
            int firstCoordinate = Integer.parseInt(coordinates[0]);
            int secondCoordinate = Integer.parseInt(coordinates[1]);

            String[][] currentArray = gameBoard.getBoard();
//            // check if user coordinates on board are empty
//
            if (currentArray[firstCoordinate][secondCoordinate] == ".") {
//                //play the move if the spot has a .
                currentArray[firstCoordinate][secondCoordinate] =
                        TicTacToe.choosePlayer(playedGames).getPlayerPiece();

                System.out.println("Move accepted, here's the current board: ");

                gameBoard.printBoard();

                    if (game.winCheck(gameBoard.getBoard())) {
                        System.out.println("Move accepted, well done you've won the game! ");
                        System.exit(0);
                    }

                        // increase playedGames if the game play goes ahead. Otherwise
                        playedGames++;



////            This is if there is not a vacant spot for the piece
                } else if (currentArray[firstCoordinate][secondCoordinate] == "X") {
                System.out.print("Oh no, a piece is already at this place! Try again...");


                } else if (currentArray[firstCoordinate][secondCoordinate] == "0") {
                System.out.print("Oh no, a piece is already at this place! Try again...");
                }
        }
    }
}

