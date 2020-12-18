package jogodavelha.game.commands.keyboard.reader;

import jogodavelha.game.commands.keyboard.validator.InputValidator;
import java.util.Scanner;


public class KeyboardCommandReader {

    InputValidator inputChecker = new InputValidator();
    Scanner scanner = new Scanner(System.in);

    public int readMove() {
        return inputChecker.isMoveBetweenOneAndNine(readNextInt());
    }

    private int readNextInt() {
        return scanner.nextInt();
    }

    public boolean readPlayAgain() {
        return inputChecker.isGameRestart(readNextInt());
    }

    public void closeKeyboard() {
        scanner.close();
    }

}
