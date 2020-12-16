package jogodavelha.game.commands.moves.validator;

import jogodavelha.game.commands.moves.position.BoardPositions;
import jogodavelha.game.gameboard.board.GameBoard;
import jogodavelha.game.main.status.GameStatus;
import jogodavelha.game.player.Players;

public class BoardMovesValidator {

    GameBoard board = new GameBoard();

    public GameStatus setMove(int position, char player) {

        if(position == 0) {
            System.out.println("Position == 0 > false");
            return GameStatus.ERROR;
        }
        if(!isPositionEmpty(findCorrectPosition(position))) {
            System.out.println("PositionEmpty > false");
            return GameStatus.ERROR;
        }
        if(!isPositionValid(findCorrectPosition(position))) {
            System.out.println("PositionValid > false");
            return GameStatus.ERROR;
        } else {
            BoardPositions pos = findCorrectPosition(position);
            board.updatePositionInBoard(pos.getPosX(), pos.getPosY(), player);
            return hasAWinner() ? GameStatus.WIN : GameStatus.VALID;
        }
    }

    private boolean isPositionEmpty(BoardPositions position) {
        return board.getSpecificPositionValue(position.getPosX(), position.getPosY()) == ' ';
    }

    private boolean isPositionValid(BoardPositions position) {
        char currentValue = board.getSpecificPositionValue(position.getPosX(), position.getPosY());
        System.out.println(currentValue);
        if(currentValue == Players.PLAYER_X.getPlayer() || currentValue == Players.PLAYER_O.getPlayer()){
            return false;
        } else {
            return true;
        }
    }

    private boolean hasAWinner() {
        // refer to all possible positions.
        char pos01 = board.getSpecificPositionValue(BoardPositions.POSITION_01.getPosX(), BoardPositions.POSITION_01.getPosY());
        char pos02 = board.getSpecificPositionValue(BoardPositions.POSITION_02.getPosX(), BoardPositions.POSITION_02.getPosY());
        char pos03 = board.getSpecificPositionValue(BoardPositions.POSITION_03.getPosX(), BoardPositions.POSITION_03.getPosY());
        char pos04 = board.getSpecificPositionValue(BoardPositions.POSITION_04.getPosX(), BoardPositions.POSITION_04.getPosY());
        char pos05 = board.getSpecificPositionValue(BoardPositions.POSITION_05.getPosX(), BoardPositions.POSITION_05.getPosY());
        char pos06 = board.getSpecificPositionValue(BoardPositions.POSITION_06.getPosX(), BoardPositions.POSITION_06.getPosY());
        char pos07 = board.getSpecificPositionValue(BoardPositions.POSITION_07.getPosX(), BoardPositions.POSITION_07.getPosY());
        char pos08 = board.getSpecificPositionValue(BoardPositions.POSITION_08.getPosX(), BoardPositions.POSITION_08.getPosY());
        char pos09 = board.getSpecificPositionValue(BoardPositions.POSITION_09.getPosX(), BoardPositions.POSITION_09.getPosY());
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
