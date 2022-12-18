package pk.rpgame.model.state;

import pk.rpgame.model.Room;
import pk.rpgame.view.PrintEventVisitor;

public class VisitedRoomState extends RoomState {
    public VisitedRoomState(Room room) {
        super(room);
    }

    @Override
    public RoomColor getColorOnMap() {
        return RoomColor.BLACK;
    }

    @Override
    public void enterRoom() {
        room.changeState(new ActiveRoomState(room));
        room.accept(new PrintEventVisitor());
    }

    @Override
    public void exitRoom() {}
}
