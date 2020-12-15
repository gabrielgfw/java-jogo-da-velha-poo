package JogoDaVelha.config.commands.keyboard.validator;

public class InputChecker {

    public boolean readPlayAgain(int answer) {
        if(answer == 1) {
            return true;
        }
        return false;
    }

    public int isMoveBetweenOneAndNine(int move) {
        if((move >= 1) & (move < 10))
            return move;
        return 0;
    }

}
