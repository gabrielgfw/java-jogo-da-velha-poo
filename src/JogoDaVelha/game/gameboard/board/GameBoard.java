package jogodavelha.game.gameboard.board;

public class GameBoard {

    public GameBoard() {
        this.resetGameBoard();
    }

    private char gameBoard[][] = new char[5][5];

    public char[][] getGameBoard() {
        return gameBoard.clone();
    }

    public char getSpecificPositionValue(int posX, int posY) {
        return gameBoard[posX][posY];
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

    public void updatePositionInBoard(int posX, int posY, char player) {
        this.gameBoard[posX][posY] = player;
    }
}
