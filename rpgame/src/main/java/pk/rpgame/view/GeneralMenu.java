package pk.rpgame.view;

import java.util.List;
import java.util.Scanner;

import pk.rpgame.model.items.Item;
import pk.rpgame.model.items.UsableItem;

public class GeneralMenu{
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

  public void printInventory(List<Item> items) {
    System.out.println("Here are the items in your inventory: ");
    int i = 1;
    for (Item item : items) {
      System.out.println(i + ". " + item.getName());
      i++;
    }
  }

  public void printNoPotionMessage() {
    System.out.println("You have no health potion in your inventory!");
  }

  public void printNothingMessageInInventory(){System.out.println("Your inventory is empty");}
  public void printMaxHealthMessage(){
    System.out.println("Max health");
  }
  public void showMenu() {
    System.out.println("1. Show inventory");
    System.out.println("2. Use health potion");
    System.out.println("3. Save game");
    System.out.println("4. Exit game");
    System.out.println("5. Back to exploration");
    int action = getAction();
    listener.onActionClick(action);
  }
}
