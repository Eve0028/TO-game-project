package pk.rpgame.model;

import pk.rpgame.MapListener;
import pk.rpgame.view.Map;

import java.util.LinkedList;
import java.util.List;

public class LevelMap extends WorldEntity {
    private List<Room> rooms;
    private final List<MapListener> listeners;

    public LevelMap(String name, List<Room> rooms) {
        super(name);
        this.rooms = rooms;
        this.listeners = new LinkedList<>();
    }

    public void changeRooms(Room exitRoom, Room enterRoom) {
        exitRoom.exitRoom();
        enterRoom.enterRoom();
        notify(exitRoom);
        notify(enterRoom);
    }

    public void subscribe(MapListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(MapListener listener) {
        listeners.remove(listener);
    }

    public void notify(Room changedRoom) {
        for(MapListener listener : this.listeners){
            listener.update(changedRoom);
        }
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
