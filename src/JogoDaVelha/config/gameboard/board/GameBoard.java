package JogoDaVelha.config.gameboard.board;

import JogoDaVelha.config.commands.moves.position.BoardPositions;

public class GameBoard {

    private char[][] gameBoard = new char[5][5];

    public char[][] getGameBoard() {
        return gameBoard;
    }

    public char getSpecificPositionValue(BoardPositions position) {
        char result = gameBoard[position.getPosX()][position.getPosY()];

        return result;
    }

    public void resetGameBoard() {
        for(int i = 4; i >= 0; i--) {
            if(i % 2 == 0) {
                for(int j = 0; j <= 4; j++) {
                    if(j % 2 == 0) {
                        this.gameBoard[i][j] = ' ';
                    } else {
                        this.gameBoard[i][j] = '|';
                    }
                }
            } else {
                for(int k = 0; k <= 4; k++) {
                    if(k % 2 == 0) {
                        this.gameBoard[i][k] = '-';
                    } else {
                        this.gameBoard[i][k] = '+';
                    }
                }
            }
        }
    }

    public void updatePositionInBoard(BoardPositions pos, char player) {
        gameBoard[pos.getPosX()][pos.getPosY()] = player;
    }
}
