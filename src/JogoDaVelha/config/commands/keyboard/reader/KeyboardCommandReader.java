package JogoDaVelha.config.commands.keyboard.reader;

import JogoDaVelha.config.commands.keyboard.validator.InputChecker;
import java.util.Scanner;


public class KeyboardCommandReader {

    InputChecker inputChecker = new InputChecker();
    Scanner scanner = new Scanner(System.in);

    public int readMove() {
        return inputChecker.isMoveBetweenOneAndNine(readAnswer());
    }

    public boolean readPlayAgain() {
        return inputChecker.readPlayAgain(readAnswer());
    }

    private int readAnswer() {
        return scanner.nextInt();
    }

    public void closeKeyboard() {
        scanner.close();
    }

}
