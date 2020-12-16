package jogodavelha.game.commands.moves.position;

public enum BoardPositions {
    POSITION_INVALID(-1,-1),
    POSITION_01(4, 0),
    POSITION_02(4, 2),
    POSITION_03(4, 4),
    POSITION_04(2, 0),
    POSITION_05(2, 2),
    POSITION_06(2, 4),
    POSITION_07(0, 0),
    POSITION_08(0, 2),
    POSITION_09(0, 4);

    private final int posX;
    private final int posY;

    BoardPositions(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
