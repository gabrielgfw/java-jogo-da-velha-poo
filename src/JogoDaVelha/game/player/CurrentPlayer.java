package jogodavelha.game.player;

public class CurrentPlayer {

    public char getCurrentPlayer(int moves) {
        if(moves % 2 == 0 || moves == 0) {
            return Players.PLAYER_X.getPlayer();
        } else {
            return Players.PLAYER_O.getPlayer();
        }
    }

}
