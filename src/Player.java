public class Player {

    private String playerPiece;
    private String name;

    public Player (String name, String playerPiece){
        this.name = name;
        this.playerPiece = playerPiece;
    }


    public String getPlayerPiece() {
        return playerPiece;
    }
    public String getName() {
        return name;
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

