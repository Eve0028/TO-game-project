package pk.rpgame;

import pk.rpgame.model.Room;

public interface Visitor {
    void visitRoom(Room room);
}
