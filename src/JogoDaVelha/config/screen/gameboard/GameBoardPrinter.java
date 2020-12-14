package JogoDaVelha.config.screen.gameboard;

public class GameBoardPrinter {

    public void printGameBoard(char[][] board) {
        for(char[] row: board) {
            System.out.print("            ");
            for(char c : row) {
                System.out.print(" ");
                System.out.print(c);
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
