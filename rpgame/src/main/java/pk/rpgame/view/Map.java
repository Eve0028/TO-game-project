package pk.rpgame.view;

//TODO
// Should be added to ExploreView

import pk.rpgame.MapListener;
import pk.rpgame.model.IntPoint;
import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.state.ActiveRoomState;
import pk.rpgame.model.state.UnvisitedRoomState;
import pk.rpgame.model.state.VisitedRoomState;

import java.util.Hashtable;

public class Map implements MapListener {
    private final int rowsCount;
    private final int columnsCount;
    private LevelMap lvMap;
    private final Hashtable<IntPoint, RoomVisualisation> mapToPrint;
    private static final String resetColor = "\\u001B[0m";

    public Map(LevelMap levelMap, int rowsCount, int columnsCount) {
        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
        this.lvMap = levelMap;
        this.mapToPrint = new Hashtable<>();

        for (int i = 0; i < rowsCount; i += 1) {
            for (int j = 0; j < rowsCount; j += 1) {
                IntPoint point = new IntPoint(i, j);
                Room findRoom = lvMap.getRooms().stream()
                        .filter(room -> point
                                .equals(room.getLocationOnMap())).findAny().orElse(null);

                if (findRoom == null) {
                    mapToPrint.put(point, RoomVisualisation.WALL);
                } else {
                    mapToPrint.put(point, getRoomType(findRoom));
                }
            }
        }
    }

    private RoomVisualisation getRoomType(Room room) {
        if (room.getState().getClass() == ActiveRoomState.class) {
            return RoomVisualisation.ACTIVE;
        } else if (room.getState().getClass() == UnvisitedRoomState.class) {
            return RoomVisualisation.NOT_VISITED;
        } else {
            return RoomVisualisation.VISITED;
        }
    }

    @Override
    public void update(Room changedRoom) {
        mapToPrint.put(changedRoom.getLocationOnMap(), getRoomType(changedRoom));
    }

    public String show() {
        StringBuilder createdMap = new StringBuilder();
        for (int i = 0; i < rowsCount; i += 1) {
            for (int j = 0; j < rowsCount; j += 1) {
                RoomVisualisation printRoom = mapToPrint.get(new IntPoint(i, j));
                createdMap.append(printRoom.getColor()).append(printRoom.getChar()).append(Map.resetColor);
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
