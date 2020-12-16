package jogodavelha.game.main;

import jogodavelha.game.main.status.CurrentGameStatus;
import jogodavelha.game.main.status.GameStatus;
import jogodavelha.game.screen.gameboard.GameBoardPrinter;
import jogodavelha.game.screen.texts.GameTextPrinter;
import jogodavelha.game.commands.moves.validator.BoardMovesValidator;
import jogodavelha.game.commands.keyboard.reader.KeyboardCommandReader;
import jogodavelha.game.gameboard.board.GameBoard;
import jogodavelha.game.player.CurrentPlayer;

public class GameController {

    KeyboardCommandReader keyboardReader = new KeyboardCommandReader();
    GameBoardPrinter boardPrinter = new GameBoardPrinter();
    GameTextPrinter textPrinter = new GameTextPrinter();
    GameBoard gameBoard = new GameBoard();
    BoardMovesValidator movesValidator = new BoardMovesValidator();
    CurrentGameStatus status = new CurrentGameStatus();
    CurrentPlayer currentPlayer = new CurrentPlayer();

    private static final int MAX_MOVES = 9;
    private boolean winner;
    private int totalMovesMade;

    public void runGame() {
        resetData();
        startGameLoop();
    }

    private void startGameLoop() {

        while(totalMovesMade <= MAX_MOVES || !winner) {
            try {
                if(status.getStatus() == GameStatus.NEW_GAME) {
                    textPrinter.printWelcome();
                }

                if(status.getStatus() == GameStatus.VALID) {
                    totalMovesMade++;
                }

                if(status.getStatus() == GameStatus.ERROR) {
                    textPrinter.printInvalidMove();
                }

                if(status.getStatus() == GameStatus.WIN) {
                    winGame();
                    callPlayAgain();
                    break;
                }

                if(totalMovesMade == MAX_MOVES) {
                    textPrinter.printMaxMoves();
                    callPlayAgain();
                    break;
                }
            } catch(RuntimeException e) {
                System.out.println(e);
                keyboardReader.closeKeyboard();
            }
            callNextMove();
        }
    }

    private void winGame() {
        winner = true;
        textPrinter.printWinner(currentPlayer.getCurrentPlayer(totalMovesMade));
        boardPrinter.printGameBoard(gameBoard);
    }

    private void callNextMove() {
        textPrinter.printCallNextMove(currentPlayer.getCurrentPlayer(totalMovesMade));
        boardPrinter.printGameBoard(gameBoard);
        status.setStatus(movesValidator.setMove(keyboardReader.readMove(), currentPlayer.getCurrentPlayer(totalMovesMade)));
    }

    private void callPlayAgain() {
        textPrinter.printPlayAgain();
        restartGame();
    }

    private boolean gameWillRestart() {
        return keyboardReader.readPlayAgain();
    }

    private void resetData() {
        status.setStatus(GameStatus.NEW_GAME);
        totalMovesMade = 0;
        winner = false;
    }

    private void restartGame() {
        if(gameWillRestart()) {
            runGame();
        } else {
            textPrinter.printGameOver();
            keyboardReader.closeKeyboard();
        }
    }

}
