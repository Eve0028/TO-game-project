package pk.rpgame.view;

import java.util.List;
import java.util.Scanner;

import pk.rpgame.model.items.UsableItem;

interface MenuClickListener {
  void onActionClick(int num);
}

public class GeneralMenu {
  private MenuClickListener listener;

  public void setListener(MenuClickListener listener) {
    this.listener = listener;
  }

  private int getAction() {
    Scanner keyboard = new Scanner(System.in);
    int action = keyboard.nextInt();
    keyboard.close();
    return action;
  }

  public void printInventory(List<UsableItem> items) {
    System.out.println("Here are the items in your inventory: ");
    int i = 1;
    for (UsableItem item : items) {
      System.out.println(i + ". " + item.getName());
      i++;
    }
  }

  public void printNoPotionMessage() {
    System.out.println("You have no health potion in your inventory!");
  }

  public void showMenu() {
    System.out.println("1. Show inventory");
    System.out.println("2. Use health potion");
    System.out.println("3. Save game");
    System.out.println("4. Exit game");
    int action = getAction();
    listener.onActionClick(action);
  }
}
