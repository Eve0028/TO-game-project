package pk.rpgame.model.state;

public enum RoomColor {
    RED("\\u001B[41m"), // Actual room
    BLUE("\\u001B[44m"), // Not visited room
    BLACK("\\u001B[40m"); // Visited room

    private final String colorStr;

    RoomColor(String colorStr) {
        this.colorStr = colorStr;
    }

    public String getColor() {
        return colorStr;
    }
}
