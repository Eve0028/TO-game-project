package pk.rpgame.model.state;

import pk.rpgame.model.Room;
import pk.rpgame.view.PrintEventVisitor;

public class UnvisitedRoomState extends RoomState {
    public UnvisitedRoomState(Room room) {
        super(room);
    }

    @Override
    public RoomColor getColorOnMap() {
        return RoomColor.BLUE;
    }

    @Override
    public void enterRoom() {
        room.changeState(new ActiveRoomState(room));
        room.accept(new PrintEventVisitor());
    }

    @Override
    public void exitRoom() {}
}
