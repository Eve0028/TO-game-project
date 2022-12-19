package pk.rpgame.view;

//TODO
// Should be added to ExploreView

import pk.rpgame.MapListener;
import pk.rpgame.model.IntPoint;
import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.state.ActiveRoomState;
import pk.rpgame.model.state.UnvisitedRoomState;

import java.util.Iterator;
import java.util.TreeMap;

public class Map implements MapListener {
    private final int rowsCount;
    private final int columnsCount;
    private LevelMap lvMap;
    private final TreeMap<IntPoint, RoomVisualisation> mapToPrint;
    private static final String resetColor = "\u001B[0m";

    public Map(LevelMap levelMap, int rowsCount, int columnsCount) {
        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
        this.lvMap = levelMap;
        this.mapToPrint = new TreeMap<>();

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

    public void show() {
        int space = 1;
        Iterator<RoomVisualisation> iterator = mapToPrint.values().iterator();
        String horizontalLine = "-".repeat((space * 2 + 2) * columnsCount + 1);
        // System.out.println(horizontalLine);

        for (int i = 0; i < rowsCount; i += 1) {
            for (int j = 0; j < rowsCount; j += 1) {
                RoomVisualisation printRoom = iterator.next();

                System.out.print("|");
                System.out.print(printRoom.getColor());
                System.out.printf("%-" + space + "s", "");
                System.out.print(printRoom.getChar());
                System.out.printf("%" + space  + "s", "");
                System.out.print(Map.resetColor);
            }
            System.out.print("|\n");
            // System.out.println(horizontalLine);
        }
        System.out.print("\n");
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
