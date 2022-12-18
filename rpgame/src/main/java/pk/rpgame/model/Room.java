package pk.rpgame.model;

import pk.rpgame.Visitor;
import pk.rpgame.model.living.LivingEntity;
import pk.rpgame.model.state.RoomState;

import java.util.List;

public class Room extends WorldEntity {
    private List<LivingEntity> creatures;

    // Is this good approach to orient rooms on the map?
    private IntPoint locationOnMap;
    private List<Room> nearestRooms;
    private RoomState state;

    public Room(String name, List<LivingEntity> creatures, IntPoint locationOnMap, List<Room> nearestRooms, RoomState state) {
        super(name);
        this.locationOnMap = locationOnMap;
        this.creatures = creatures;
        this.nearestRooms = nearestRooms;
        this.state = state;
    }

    public void changeState(RoomState state) {
        this.state = state;
    }

    public RoomState getState() {
        return state;
    }

    public void enterRoom() {
        state.enterRoom();
    }

    public void exitRoom() {
        state.exitRoom();
    }

    public void accept(Visitor visitor){
        visitor.visitRoom(this);
    }

    public List<LivingEntity> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<LivingEntity> creatures) {
        this.creatures = creatures;
    }

    public IntPoint getLocationOnMap() {
        return locationOnMap;
    }

    public void setLocationOnMap(IntPoint locationOnMap) {
        this.locationOnMap = locationOnMap;
    }

    public List<Room> getNearestRooms() {
        return nearestRooms;
    }

    public void setNearestRooms(List<Room> nearestRooms) {
        this.nearestRooms = nearestRooms;
    }
}
