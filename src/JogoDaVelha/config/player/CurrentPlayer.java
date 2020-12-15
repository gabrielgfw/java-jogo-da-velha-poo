package JogoDaVelha.config.player;

public class CurrentPlayer {

    private Players currentPlayer;

    public char getCurrentPlayer(int moves) {
        if(moves % 2 == 0 || moves == 0) {
            return currentPlayer.PLAYER_X.getPlayer();
        } else return currentPlayer.PLAYER_O.getPlayer();
    }

}
