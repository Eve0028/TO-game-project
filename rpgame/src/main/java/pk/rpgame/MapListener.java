package pk.rpgame;

import pk.rpgame.model.Room;

public interface MapListener {
    void update(Room changedRoom);
}
