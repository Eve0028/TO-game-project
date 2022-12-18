package pk.rpgame.model.state;

import pk.rpgame.model.Room;
import pk.rpgame.view.PrintEventVisitor;

public class ActiveRoomState extends RoomState {
    public ActiveRoomState(Room room) {
        super(room);
    }

    @Override
    public RoomColor getColorOnMap() {
        return RoomColor.RED;
    }

    @Override
    public void enterRoom() {}

    @Override
    public void exitRoom() {
        room.changeState(new VisitedRoomState(room));
        room.accept(new PrintEventVisitor());
    }
}
