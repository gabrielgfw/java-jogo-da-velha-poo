package JogoDaVelha.config.main;

import JogoDaVelha.config.commands.moves.validator.BoardMovesValidator;
import JogoDaVelha.config.commands.keyboard.reader.KeyboardCommandReader;
import JogoDaVelha.config.gameboard.board.GameBoard;
import JogoDaVelha.config.main.status.CurrentGameStatus;
import JogoDaVelha.config.main.status.GameStatus;
import JogoDaVelha.config.player.CurrentPlayer;
import JogoDaVelha.config.screen.gameboard.GameBoardPrinter;
import JogoDaVelha.config.screen.texts.GameTextPrinter;

public class GameController {

    KeyboardCommandReader keyboardReader = new KeyboardCommandReader();
    GameBoardPrinter boardPrinter = new GameBoardPrinter();
    GameTextPrinter textPrinter = new GameTextPrinter();
    GameBoard gameBoard = new GameBoard();
    BoardMovesValidator movesValidator = new BoardMovesValidator();
    CurrentGameStatus status = new CurrentGameStatus(GameStatus.NEW_GAME);
    CurrentPlayer currentPlayer = new CurrentPlayer();

    private static final int MAX_MOVES = 9;
    private boolean winner;
    private int movesMade;

    public void runGame() {
        gameBoard.resetGameBoard();
        startGameLoop();
    }

    private void startGameLoop() {
        while(movesMade <= MAX_MOVES || !winner) {

            if(status.getStatus() == GameStatus.NEW_GAME) {
                resetData();
                textPrinter.printWelcome();
            }

            if(status.getStatus() == GameStatus.VALID) {
                movesMade++;
            }

            if(status.getStatus() == GameStatus.ERROR) {
                textPrinter.printInvalidMove();
            }

            if(status.getStatus() == GameStatus.WIN) {
                winGame();
                callPlayAgain();
                break;
            }

            if(movesMade == MAX_MOVES) {
                textPrinter.printMaxMoves();
                callPlayAgain();
                break;
            }

            callNextMove();
        }
    }

    private void callNextMove() {
        textPrinter.printCallNextMove(currentPlayer.getCurrentPlayer(movesMade));
        boardPrinter.printGameBoard(gameBoard.getGameBoard());
        status.setStatus(movesValidator.setMove(keyboardReader.readMove(), currentPlayer.getCurrentPlayer(movesMade)));
    }

    private void winGame() {
        winner = true;
        textPrinter.printWinner(currentPlayer.getCurrentPlayer(movesMade));
        boardPrinter.printGameBoard(gameBoard.getGameBoard());
    }

    private void callPlayAgain() {
        textPrinter.printPlayAgain();

        if(gameWillRestart()) {
            runGame();
        } else {
            textPrinter.printGameOver();
            keyboardReader.closeKeyboard();
        }
    }

    private boolean gameWillRestart() {
        if(keyboardReader.readPlayAgain())
            return true;
        return false;
    }

    private void resetData() {
        movesMade = 0;
        winner = false;
    }

}
