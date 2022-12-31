package pk.rpgame.view;

import pk.rpgame.model.Room;

import java.util.List;

public class ExplorationView {
    private final Room currentRoom;

    public ExplorationView(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void printRoomDescription() {
        System.out.println("W tym pokoju jesteś bezpieczny. Nie ma tu żadnych potworów.");
    }

    public void printNearestRooms() {
        List<Room> nearestRooms = this.currentRoom.getNearestRooms();
        System.out.println("Możliwe pomieszczenia, do których możesz się udać: " + nearestRooms);
    }
}
