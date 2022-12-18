package pk.rpgame.view;

//TODO
// Should be added to ExploreView

import pk.rpgame.model.IntPoint;
import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.state.RoomColor;

public class Map {
    private final int rowsCount;
    private final int columnsCount;
    private LevelMap lvMap;

    public Map(LevelMap levelMap, int rowsCount, int columnsCount) {
        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
        this.lvMap = levelMap;
    }

    //TODO
    // It will be better when the generator will be in the constructor
    // And only two rooms will be actualized when Hero go to another room
    public String show() {
        StringBuilder createdMap = new StringBuilder();
        for (int i = 0; i < rowsCount; i += 1) {
            for (int j = 0; j < rowsCount; j += 1) {
                int finalI = i;
                int finalJ = j;
                Room findRoom = lvMap.getRooms().stream()
                        .filter(room -> new IntPoint(finalI, finalJ)
                                .equals(room.getLocationOnMap())).findAny().orElse(null);
                if (findRoom != null) {
                    String color = findRoom.getState().getColorOnMap().getColor();
                    createdMap.append(color).append("o").append(RoomColor.BLACK.getColor());
                } else {
                    createdMap.append(RoomColor.BLACK.getColor()).append("#");
                }
            }
            createdMap.append('\n');
        }
        return createdMap.toString();
    }

    public int getRowsCount() {
        return rowsCount;
    }

    public int getColumnsCount() {
        return columnsCount;
    }

    public LevelMap getLvMap() {
        return lvMap;
    }

    public void setLvMap(LevelMap lvMap) {
        this.lvMap = lvMap;
    }
}
