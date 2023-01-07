package pk.rpgame.view;

import pk.rpgame.model.Room;
import java.util.List;
import java.util.Scanner;


public class ExplorationView {

  private MenuClickListener listener;

  public void printRoomDescription(Room room) {
    System.out.println("You are in a room called " + room.getName());
      System.out.println("You are safe in this room. There are no monsters here.");

  }

  public void setListener(MenuClickListener listener) {
    this.listener = listener;
  }

  private int getAction() {
    Scanner keyboard = new Scanner(System.in);
    int action = keyboard.nextInt();
    keyboard.close();
    return action;
  }

  public int getRoomChoice(List<Room> nearestRooms) {
    System.out.println("Rooms available to visit: ");
    int i = 1;
    for (Room room : nearestRooms) {
      System.out.println(i + ". " + room.getName());
      i++;
    }
    System.out.print("Pick number of the room you wish to go next: ");
    int action = getAction();
    while (true) {
      if (action < 1 || action > nearestRooms.size()) {
        System.out.println("Pick a correct number!");
        action = getAction();
      } else {
        break;
      }
    }
    return action;
  }

  public PickUpItems pickUpItems() {
    System.out.println(
        "You can pick up the item you found. Choose '1' to pick them or '0' to do nothing.");
    System.out.println(
        "If you pick up a weapon or an armor, you will loose your current item of that category. Choose wisely!");
    int action = getAction();
    while (true) {
      if (action == 1) {
        return PickUpItems.PICK_UP;
      } else if (action == 0) {
        return PickUpItems.DONT_PICK_UP;
      } else {
        System.out.println("Pick a correct number!");
      }
      action = getAction();
    }
  }

  public void showMenu() {
    System.out.println("1. Explore this room");
    System.out.println("2. Go to the next room");
    System.out.println("3. Show map");
    System.out.println("4. Show menu");
    int action = getAction();
    listener.onActionClick(action);
  }
}
