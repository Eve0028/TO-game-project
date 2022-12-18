package pk.rpgame.model.state;

import pk.rpgame.model.Room;

public abstract class RoomState {
    protected Room room;

    public RoomState(Room room){
        this.room = room;
    }

    public abstract RoomColor getColorOnMap();
    public abstract void enterRoom();
    public abstract void exitRoom();
}
