package jogodavelha.game.player;

public enum Players {
    PLAYER_X('X'),
    PLAYER_O('O');

    private final char player;

    Players(char player) {
        this.player = player;
    }

    public char getPlayer(){
        return player;
    }
}
