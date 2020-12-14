package JogoDaVelha.config.board;

import JogoDaVelha.config.enums.BoardPositions;
import JogoDaVelha.config.enums.CurrentGameState;

public class GameBoard {

    private BoardPositions positionPlayed;
    private CurrentGameState response;
    private char[][] gameBoard =
     {{' ', '|', ' ', '|', ' '},
      {'-', '+', '-', '+', '-'},
      {' ', '|', ' ', '|', ' '},
      {'-', '+', '-', '+', '-'},
      {' ', '|', ' ', '|', ' '}};


    public char[][] getGameBoard() {
        return gameBoard;
    }

    public void resetGameBoard() {
        for (int i = 4; i >= 0; i--) {
            if (i % 2 == 0) {
                for (int j = 0; j <= 4; j++) {
                    if (j % 2 == 0)
                        this.gameBoard[i][j] = ' ';
                }
            }
        }
        response = CurrentGameState.NEW_GAME;
    }

    public void setMove(int position, char player) {
        positionPlayed = findCorrectPosition(position);

        if(position == 0 || !isPositionEmpty(positionPlayed) || !isPositionValid(positionPlayed)) {
            response = CurrentGameState.ERROR;
        } else {
            gameBoard[positionPlayed.getPosX()][positionPlayed.getPosY()] = player;
            response = CurrentGameState.VALID;
        }
        if(hasAWinner())
            response = CurrentGameState.WIN;
    }

    public CurrentGameState getCurrentGameState() {
        return response;
    }

    private char getBoardCoordinates(BoardPositions position) {
        return gameBoard[position.getPosX()][position.getPosY()];
    }

    private boolean isPositionEmpty(BoardPositions position) {
        char empty = ' ';

        if(getBoardCoordinates(position) == empty)
            return true;
        return false;
    }

    private boolean isPositionValid(BoardPositions position) {
        char x = 'X';
        char o = 'O';

        if(gameBoard[positionPlayed.getPosX()][positionPlayed.getPosY()] == x)
            return false;
        if(gameBoard[positionPlayed.getPosX()][positionPlayed.getPosY()] == o)
            return false;
        return true;
    }

    private boolean hasAWinner() {
        // refer to all possible positions.
        char pos01 = getBoardCoordinates(BoardPositions.POSITION_01);
        char pos02 = getBoardCoordinates(BoardPositions.POSITION_02);
        char pos03 = getBoardCoordinates(BoardPositions.POSITION_03);
        char pos04 = getBoardCoordinates(BoardPositions.POSITION_04);
        char pos05 = getBoardCoordinates(BoardPositions.POSITION_05);
        char pos06 = getBoardCoordinates(BoardPositions.POSITION_06);
        char pos07 = getBoardCoordinates(BoardPositions.POSITION_07);
        char pos08 = getBoardCoordinates(BoardPositions.POSITION_08);
        char pos09 = getBoardCoordinates(BoardPositions.POSITION_09);
        // checking all positions content.
        boolean pos01Empty = isPositionEmpty(BoardPositions.POSITION_01);
        boolean pos02Empty = isPositionEmpty(BoardPositions.POSITION_02);
        boolean pos03Empty = isPositionEmpty(BoardPositions.POSITION_03);
        boolean pos04Empty = isPositionEmpty(BoardPositions.POSITION_04);
        boolean pos05Empty = isPositionEmpty(BoardPositions.POSITION_05);
        boolean pos06Empty = isPositionEmpty(BoardPositions.POSITION_06);
        boolean pos07Empty = isPositionEmpty(BoardPositions.POSITION_07);
        boolean pos08Empty = isPositionEmpty(BoardPositions.POSITION_08);
        boolean pos09Empty = isPositionEmpty(BoardPositions.POSITION_09);

        // horizontal possibilities.
        if(pos01 == pos02 && pos01 == pos03 && !pos01Empty && !pos02Empty && !pos03Empty)
            return true;
        if(pos04 == pos05 && pos04 == pos06 && !pos04Empty && !pos05Empty && !pos06Empty)
            return true;
        if(pos07 == pos08 && pos07 == pos09 && !pos07Empty && !pos08Empty && !pos09Empty)
            return true;

        // vertical possibilities.
        if(pos01 == pos04 && pos01 == pos07 && !pos01Empty  && !pos04Empty && !pos07Empty)
            return true;
        if(pos02 == pos05 && pos02 == pos08 && !pos02Empty && !pos05Empty && !pos08Empty)
            return true;
        if(pos03 == pos06 && pos03 == pos09 && !pos03Empty && !pos06Empty && !pos09Empty)
            return true;

        // diagonal possibilities.
        if(pos01 == pos05 && pos01 == pos09 && !pos01Empty && !pos05Empty && !pos09Empty)
            return true;
        if(pos07 == pos05 && pos07 == pos03 && !pos07Empty && !pos05Empty && !pos03Empty)
            return true;

        return false;
    }

    private BoardPositions findCorrectPosition(int position) {
        if(position == 1)
            return BoardPositions.POSITION_01;
        if(position == 2)
            return BoardPositions.POSITION_02;
        if(position == 3)
            return BoardPositions.POSITION_03;
        if(position == 4)
            return BoardPositions.POSITION_04;
        if(position == 5)
            return BoardPositions.POSITION_05;
        if(position == 6)
            return BoardPositions.POSITION_06;
        if(position == 7)
            return BoardPositions.POSITION_07;
        if(position == 8)
            return BoardPositions.POSITION_08;
        if(position == 9)
            return BoardPositions.POSITION_09;

        return BoardPositions.POSITION_INVALID;
    }
 }
