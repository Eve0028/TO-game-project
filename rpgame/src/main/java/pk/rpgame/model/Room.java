package pk.rpgame.model;

import java.awt.*;
import java.util.List;

public class Room extends WorldEntity {
    private List<LivingEntity> creatures;

    // Is this good approach to orient rooms on the map?
    private Point locationOnMap;
    private List<Room> nearestRooms;

    public Room(String name, List<LivingEntity> creatures, Point locationOnMap, List<Room> nearestRooms) {
        super(name);
        this.locationOnMap = locationOnMap;
        this.creatures = creatures;
        this.nearestRooms = nearestRooms;
    }

    @Override
    public String toString() {
        return null;
    }

    public List<LivingEntity> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<LivingEntity> creatures) {
        this.creatures = creatures;
    }

    public Point getLocationOnMap() {
        return locationOnMap;
    }

    public void setLocationOnMap(Point locationOnMap) {
        this.locationOnMap = locationOnMap;
    }

    public List<Room> getNearestRooms() {
        return nearestRooms;
    }

    public void setNearestRooms(List<Room> nearestRooms) {
        this.nearestRooms = nearestRooms;
    }
}
