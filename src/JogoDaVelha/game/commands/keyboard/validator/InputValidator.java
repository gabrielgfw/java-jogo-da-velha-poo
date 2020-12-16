package jogodavelha.game.commands.keyboard.validator;

public class InputValidator {


    public int isMoveBetweenOneAndNine(int move) {
        if((move >= 1) & (move < 10)) {
            return move;
        } else return 0;
    }

    public boolean isGameRestart(int answer) {
        return answer == 1;
    }

}
