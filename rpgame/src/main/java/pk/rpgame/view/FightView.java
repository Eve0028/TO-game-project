package pk.rpgame.view;

import java.util.List;
import java.util.Scanner;

import pk.rpgame.model.Room;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.living.Hero;
import pk.rpgame.model.living.LivingEntity;

public class FightView implements IView {

  private MenuClickListener listener;

  public void printRoomDescription(Room room) {
    System.out.println("You are in a room called " + room.getName());
    System.out.println("There are several monsters in this room.");
    System.out.println("A fight will start soon!");
  }

  public void setListener(MenuClickListener listener) {
    this.listener = listener;
  }

  public void printEnemies(List<LivingEntity> monsters) {
    System.out.println("These are the monsters that guard this room: ");
    int i = 1;
    for (LivingEntity monster : monsters) {
      System.out.println(i + ". " + monster.getName() + ", " + monster.getHealth() + " health points");
      i++;
    }
  }

  public void printHeroHealth(Hero hero) {
    System.out.println("You currently have " + hero.getHealth() + " health points");
  }

  public int getMonsterChoice(List<LivingEntity> monsters) {
    printEnemies(monsters);
    System.out.print("Choose number of the monster you wish to attack: ");
    int action = getAction();
    while (true) {
      if (action > monsters.size() || action < 1) {
        System.out.println("Pick a correct number!");
        action = getAction();
      } else {
        break;
      }
    }
    return action;
  }

  public void printMonsterDeath(String monsterName) {
    System.out.println("Monster " + monsterName + " is dead");
  }

  public void heroDeath() {
    System.out.println("YOU ARE DEAD");
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

  public void printNothingMessageInInventory() {
    System.out.println("Your inventory is empty");
  }

  public void printAttackResult(String attackerName, String deffenderName, double damage) {
    System.out.println(attackerName + " attacked " + deffenderName + " dealing " + damage + " damage.");
  }

  public void wrongChoice() {
    System.out.println("Wrong choice!!");
  }

  public void fullHpMessage() {
    System.out.println("Your HP is full.");
  }

  public void endGameMessage() {
    System.out.println("Shutdown a game!");
  }

  public void blockHero(LivingEntity monster) {
    System.out.println("You block attack form " + monster.getName());
  }

  public void winRoom() {
    System.out.println("You defeat them all!");
  }

  public void showMenu() {
    System.out.println("1. Attack");
    System.out.println("2. Defend");
    System.out.println("3. Use an item");
    System.out.println("4. Escape");
    int action = getAction();
    listener.onActionClick(action);
  }
}
