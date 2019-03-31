import java.util.Scanner;


public class TicTacToe {

    public Boolean winCheck(String[][] currentBoardArray) {
//      Checks horizontal
        for (int currentRowIndex = 0; currentRowIndex < currentBoardArray.length; currentRowIndex++){
            String[] elements = new String[3];

            for (int currentColIndex = 0; currentColIndex < currentBoardArray[currentRowIndex].length; currentColIndex++) {
                String currentColValue = currentBoardArray[currentRowIndex][currentColIndex];
                elements[currentColIndex] = currentColValue;
            }

            if (isWon(elements)) {
                return true;
            }
        }

//      Checks vertical
        for (int currentColIndex = 0; currentColIndex < 3; currentColIndex++){
            String [] elements = new String [3];

            for (int currentRowIndex = 0; currentRowIndex < currentBoardArray.length; currentRowIndex++){

                elements[currentRowIndex] = currentBoardArray[currentRowIndex][currentColIndex];
            }
            if (isWon(elements)){
                return true;
            }
        }

        String firstPosition = currentBoardArray[0][0];
        String secondPosition = currentBoardArray[1][1];
        String thirdPosition = currentBoardArray[2][2];
        String [] diagonalElements = {firstPosition, secondPosition, thirdPosition};



        if (isWon(diagonalElements)){
            return true;
        }


        diagonalElements[0] = currentBoardArray[0][2];
        diagonalElements[1] = currentBoardArray[1][1];
        diagonalElements[2] = currentBoardArray[2][0];

        if (isWon(diagonalElements)){
            return true;
        }



        return false;
    }




    public Boolean isWon(String[] currentArray) {
        String firstChar = currentArray[0];

        if (firstChar == ".") {
            return false;
        } else if (firstChar == "X" || firstChar == "0") {
            for (int index = 0; index < currentArray.length; index++) {
                if (firstChar != currentArray[index]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static Player choosePlayer(int playedGames) {
        Player currentPlayer;

        if (playedGames % 2 == 0) {
            currentPlayer = new Player("Player 1", "X");
        } else {
            currentPlayer = new Player("Player 2", "0");
        }
        return currentPlayer;
    }
}