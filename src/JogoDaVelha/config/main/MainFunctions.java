package JogoDaVelha.config.main;

import JogoDaVelha.config.board.GameBoard;
import JogoDaVelha.config.commands.KeyboardControls;
import JogoDaVelha.config.enums.CurrentGameState;
import JogoDaVelha.config.screen.ScreenRender;

public class MainFunctions {

    KeyboardControls keyboard = new KeyboardControls();
    ScreenRender screen = new ScreenRender();
    GameBoard board = new GameBoard();
    private static final int MAX_MOVES = 9;
    private boolean winner;
    private int movesMade;

    public void runGame() {
        board.resetGameBoard();
        startGameLoop();
    }

    private void startGameLoop() {
        while(movesMade <= MAX_MOVES || !winner) {

            if(board.getCurrentGameState() == CurrentGameState.VALID) {
                movesMade++;
            }

            if(board.getCurrentGameState() == CurrentGameState.NEW_GAME) {
                resetData();
                screen.printWelcome();
            }

            if(board.getCurrentGameState() == CurrentGameState.ERROR) {
                screen.printInvalidMove();
            }

            if(board.getCurrentGameState() == CurrentGameState.WIN) {
                winGame();
                callPlayAgain();
                break;
            }

            if(movesMade == MAX_MOVES) {
                screen.printMaxMoves();
                callPlayAgain();
                break;
            }

            callNextMove();
        }
    }

    private void callNextMove() {
        screen.printCallNextMove(checkIfItsCircleOrX(movesMade));
        screen.printGameBoard(board.getGameBoard());
        board.setMove(keyboard.readMove(), checkIfItsCircleOrX(movesMade));

    }

    private void winGame() {
        winner = true;
        screen.printWinner(checkIfItsCircleOrX(movesMade));
        screen.printGameBoard(board.getGameBoard());
    }

    private void callPlayAgain() {
        screen.printPlayAgain();

        if(gameWillRestart()) {
            runGame();
        } else {
            screen.printGameOver();
            keyboard.closeKeyboard();
        }
    }

    private boolean gameWillRestart() {
        if(keyboard.readPlayAgain())
            return true;
        return false;
    }

    private void resetData() {
        movesMade = 0;
        winner = false;
    }

    private char checkIfItsCircleOrX(int movesMade) {
        if(movesMade % 2 == 0 || movesMade == 0) {
            return 'X';
        }
        return 'O';
    }

}
