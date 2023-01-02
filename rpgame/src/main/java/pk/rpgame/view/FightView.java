package pk.rpgame.view;

import java.util.List;
import java.util.Scanner;

import pk.rpgame.model.items.UsableItem;
import pk.rpgame.model.living.Hero;
import pk.rpgame.model.living.Monster;

interface FightClickListener {
  void onActionClick(int num);
}

public class FightView {

  private FightClickListener listener;

  public void setListener(FightClickListener listener) {
    this.listener = listener;
  }

  private int getAction() {
    Scanner keyboard = new Scanner(System.in);
    int action = keyboard.nextInt();
    keyboard.close();
    return action;
  }

  public void printEnemies(List<Monster> monsters) {
    System.out.println("These are the monsters that guard this room: ");
    int i = 1;
    for (Monster monster : monsters) {
      System.out.println(i + ". " + monster.getName() + ", " + monster.getHealth() + " health points");
      i++;
    }
  }

  public void printHeroHealth(Hero hero) {
    System.out.println("You currently have " + hero.getHealth() + " health points");
  }

  public int getMonsterChoice(List<Monster> monsters) {
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

  public int getItemChoice(List<UsableItem> items) {
    System.out.println("Here are the items in your inventory: ");
    for (UsableItem item : items) {
      int i = 1;
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

  public void printAttackResult(String attackerName, String deffenderName, double damage) {
    System.out.println(attackerName + " attacked " + deffenderName + " dealing " + damage + " damage.");
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
