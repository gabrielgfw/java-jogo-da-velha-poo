package JogoDaVelha.config.main.status;

public class CurrentGameStatus {

    private GameStatus status;

    public CurrentGameStatus(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }
}
