package pk.rpgame.model;

import pk.rpgame.Visitor;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.living.LivingEntity;
import pk.rpgame.model.state.RoomState;
import pk.rpgame.model.state.UnvisitedRoomState;

import java.util.ArrayList;
import java.util.List;

public class Room extends WorldEntity {
    private List<LivingEntity> creatures;
    private List<Item> items;

    private IntPoint locationOnMap;
    private List<Room> nearestRooms;
    private RoomState state;

    public Room(String name, List<LivingEntity> creatures, List<Item> items, IntPoint locationOnMap,
                List<Room> nearestRooms) {
        super(name);
        this.locationOnMap = locationOnMap;
        this.creatures = creatures;
        this.items = items;
        this.nearestRooms = nearestRooms;
        this.state = new UnvisitedRoomState(this);
    }

    public Room(String name, List<LivingEntity> creatures, List<Item> items, IntPoint locationOnMap) {
        super(name);
        this.locationOnMap = locationOnMap;
        this.creatures = creatures;
        this.items = items;
        this.nearestRooms = new ArrayList<>();
        this.state = new UnvisitedRoomState(this);
    }

    public void addNearRoom(Room nearRoom) {
        this.nearestRooms.add(nearRoom);
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

    public void accept(Visitor visitor) {
        visitor.visitRoom(this);
    }

    public List<LivingEntity> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<LivingEntity> creatures) {
        this.creatures = creatures;
    }

    public void addCreature(LivingEntity creature) {
        this.creatures.add(creature);
    }

    public void removeCreature(LivingEntity creature) {
        this.creatures.remove(creature);
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setState(RoomState state) {
        this.state = state;
    }
}
