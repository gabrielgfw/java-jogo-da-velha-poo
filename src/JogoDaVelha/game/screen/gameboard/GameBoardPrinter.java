package jogodavelha.game.screen.gameboard;

import jogodavelha.game.gameboard.board.GameBoard;

public class GameBoardPrinter {

    GameBoard board = new GameBoard();

    public void printGameBoard() {

        for(int i = 0; i <= 4 ; i++) {
            System.out.print("            ");
            for(int j = 0; j <= 4; j++) {
                System.out.print(" ");
                System.out.print(board.getGameBoard()[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }


        System.out.println(",----------------------------------.");
        System.out.println("| ~´*`~ ~´*`~ ~´*`´*`~ ~´*`~ ~´*`~ |:.");
        System.out.println("`----------------------------------´:::");
        System.out.println("  `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´::");
        System.out.println("     `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´");
    }

}
