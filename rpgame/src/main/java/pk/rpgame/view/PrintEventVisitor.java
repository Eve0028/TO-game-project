package pk.rpgame.view;

import pk.rpgame.Visitor;
import pk.rpgame.model.Room;
import pk.rpgame.model.state.ActiveRoomState;
import pk.rpgame.model.state.VisitedRoomState;

public class PrintEventVisitor implements Visitor {
    public void visitRoom(Room room) {
        if (room.getState().getClass() == ActiveRoomState.class) {
            System.out.println("You entered " + room);

        } else if (room.getState().getClass() == VisitedRoomState.class) {
            System.out.println("You leave " + room);
        }
    }
}
