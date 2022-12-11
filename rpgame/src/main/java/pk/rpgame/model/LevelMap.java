package pk.rpgame.model;

import java.util.List;

public class LevelMap extends WorldEntity {
    private List<Room> rooms;

    public LevelMap(String name, List<Room> rooms) {
        super(name);
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        StringBuilder allRooms = new StringBuilder();
        allRooms.append(super.toString());
        for (Room room : rooms){
            allRooms.append(room.toString());
        }
        return allRooms.toString();
    }
}
