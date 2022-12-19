package pk.rpgame.view;

public enum RoomVisualisation {
    ACTIVE("\\u001B[41m", 'x'), // Red color
    NOT_VISITED("\\u001B[40m", '#'), // Gray color
    VISITED("\\u001B[44m", 'o'), // Blue color
    WALL("\\u001B[40m", '#');

    private final String colorStr;
    private final Character charRoom;
    RoomVisualisation(String colorStr, Character charRoom) {
        this.colorStr = colorStr;
        this.charRoom = charRoom;
    }

    public String getColor() {
        return colorStr;
    }
    public Character getChar() {
        return charRoom;
    }
}