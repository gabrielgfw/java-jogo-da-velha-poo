package JogoDaVelha.config.screen;

public class GameTextPrinter {

    public void printWelcome() {
        System.out.println(",----------------------------------.");
        System.out.println("| ~´*`~ ~´*`~ ~´*`´*`~ ~´*`~ ~´*`~ |:.");
        System.out.println("|   Bem-vindo ao jogo da velha!    |::.");
        System.out.println("| ~´*`~ ~´*`~ ~´*`´*`~ ~´*`~ ~´*`~ |:::");
        System.out.println("`----------------------------------´:::");
        System.out.println("  `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´::");
        System.out.println("     `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´");
    }

    public void printCallNextMove(char player) {
        System.out.println(",----------------------------------.");
        System.out.println("|  Digite uma posição para jogar:  |:.");
        System.out.println("|               1 a 9              |::.");
        System.out.println("|        Vez do jogador: " + player + ".        |:::");
        System.out.println("`----------------------------------´:::");
        System.out.println("  `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´::");
        System.out.println("     `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´");
    }

    public void printInvalidMove() {
        System.out.println(",----------------[!]---------------.");
        System.out.println("|Jogada Inválida, tente novamente! |:.");
        System.out.println("`----------------[!]---------------´:::");
        System.out.println("  `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´::");
        System.out.println("     `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´");
    }

    public void printWinner(char winner) {
        System.out.println(",----------------------------------.");
        System.out.println("| ~´*`~ ~´*`~ ~´*`´*`~ ~´*`~ ~´*`~ |:.");
        System.out.println("|----------------------------------|:::");
        System.out.println("|         O Jogo terminou!         |:::");
        System.out.println("|       Parabéns jogador '" + winner + "'       |:::");
        System.out.println("|         Você é o campeão!!       |:::");
        System.out.println("|----------------------------------|:::");
        System.out.println("| ~´*`~ ~´*`~ ~´*`´*`~ ~´*`~ ~´*`~ |:::");
        System.out.println("`----------------------------------´:::");
        System.out.println("  `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´::");
        System.out.println("     `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´");
    }

    public void printMaxMoves() {
        System.out.println(",----------------------------------.");
        System.out.println("|         Ninguém ganhou :(        |:.");
        System.out.println("`----------------------------------´:::");
        System.out.println("  `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´::");
        System.out.println("     `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´");
    }

    public void printPlayAgain() {
        System.out.println(",----------------------------------.");
        System.out.println("|      Deseja Jogar Novamente?     |:.");
        System.out.println("|        [1]Sim     [2]Não         |:::");
        System.out.println("`----------------------------------´:::");
        System.out.println("  `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´::");
        System.out.println("     `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´");
    }

    public void printGameOver() {
        System.out.println(",----------------------------------.");
        System.out.println("|        Obrigado por jogar!       |:.");
        System.out.println("|          Encerrando jogo!        |:::");
        System.out.println("`----------------------------------´:::");
        System.out.println("  `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´::");
        System.out.println("     `¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨´");
    }


}
