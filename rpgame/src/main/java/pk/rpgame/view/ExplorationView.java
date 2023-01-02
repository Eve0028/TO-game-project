package pk.rpgame.view;

import pk.rpgame.model.Room;
import java.util.List;
import java.util.Scanner;

interface MenuClickListener {
    void onActionClick(int num);
}

enum PickUpItems {
    PICK_UP,
    DONT_PICK_UP
}

public class ExplorationView {

    private MenuClickListener listener;

    public void printRoomDescription(String roomName) {
        System.out.println("Znajdujesz się w pomieszczeniu " + roomName);
        System.out.println("W tym pokoju jesteś bezpieczny. Nie ma tu żadnych potworów.");
    }

    public void setListener(MenuClickListener listener) {
        this.listener = listener;
    }

    private int getAction() {
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextInt();
    }

    public void printNearestRooms(List<Room> nearestRooms) {
        System.out.println("Możliwe pomieszczenia, do których możesz się udać: " + nearestRooms);
    }

    public PickUpItems pickUpItems() {
        System.out.println(
                "Możesz podnieść znalezione przedmioty. Wybierz '1' aby je podnieść lub '0' aby nic nie robić.");
        System.out.println(
                "Podniesienie pancerza lub broni spowoduje upuszczenie aktualnie noszonych przedmiotów z tej kategorii");
        int action = getAction();
        while (true) {
            if (action == 1) {
                return PickUpItems.PICK_UP;
            } else if (action == 0) {
                return PickUpItems.DONT_PICK_UP;
            } else {
                System.out.println("Wybierz właściwą cyfrę!");
            }
            action = getAction();
        }
    }

    public void showMenu() {
        System.out.println("1. Eksploruj pomieszczenie");
        System.out.println("2. Przejdź do następnego pokoju");
        System.out.println("3. Pokaż mapę");
        System.out.println("4. Pokaż menu");
        int action = getAction();
        listener.onActionClick(action);
    }
}
