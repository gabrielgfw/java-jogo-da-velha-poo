package JogoDaVelha.config.commands;

import java.util.Scanner;

public class KeyboardControls {

    Scanner scanner = new Scanner(System.in);
    private int answer;

    public int readMove() {
        answer = scanner.nextInt();

        if(isMoveBetweenOneAndNine(answer))
            return answer;
        return 0;
    }

    public void closeKeyboard() {
        scanner.close();
    }

    public boolean readPlayAgain() {
        answer = scanner.nextInt();

        if(answer == 1) {
            return true;
        }
        return false;
    }

    private boolean isMoveBetweenOneAndNine(int move) {
        if((move >= 1) & (move < 10))
            return true;
        return false;
    }

}
