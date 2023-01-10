package pk.rpgame.view;

import java.util.List;

import pk.rpgame.model.items.Item;
import pk.rpgame.model.living.Hero;

public class GeneralMenu implements IView {
  private MenuClickListener listener;

  public void setListener(MenuClickListener listener) {
    this.listener = listener;
  }

  public void printInventory(List<Item> items) {
    System.out.println("Here are the items in your inventory: ");
    int i = 1;
    for (Item item : items) {
      System.out.println(i + ". " + item.getName() + "\n");
      i++;
    }
  }

  public void printNoPotionMessage() {
    System.out.println("You have no health potion in your inventory!");
  }

  public void endGameMessage() {
    System.out.println("Shutdown a game!");
  }

  public int getItemChoice(List<Item> items) {
    System.out.println("Here are the items in your inventory: ");
    int i = 1;
    for (Item item : items) {
      System.out.println(i + ". " + item.getName());
      i++;
    }
    System.out.print("Choose number of the item you wish yo use: ");
    int action = getAction();
    while (true) {
      if (action > items.size() || action < 1) {
        System.out.println("Pick a correct number!");
        action = getAction();
      } else {
        break;
      }
    }
    return action;
  }

  public void printHeroHealth(Hero hero) {
    System.out.println("You currently have " + hero.getHealth() + " health points");
  }

  public void fullHpMessage() {
    System.out.println("Your HP is full.");
  }

  public void printNothingMessageInInventory() {
    System.out.println("Your inventory is empty");
  }

  public void printMaxHealthMessage() {
    System.out.println("Max health");
  }

  public void wrongChoice() {
    System.out.println("Wrong choice!!");
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
