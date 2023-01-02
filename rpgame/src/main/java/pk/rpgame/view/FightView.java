package pk.rpgame.view;

import java.util.List;
import java.util.Scanner;

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
    System.out.println("W pokoju znajdują się następujący przeciwnicy: ");
    for (Monster monster : monsters) {
      int i = 1;
      System.out.println(i + ". " + monster.getName() + ", " + monster.getHealth() + " pkt życia");
      i++;
    }
  }

  public void printHeroHealth(Hero hero) {
    System.out.println("Posiadasz obecnie " + hero.getHealth() + " pkt życia");
  }

  public int askWhichMonsterToAttack(List<Monster> monsters) {
    printEnemies(monsters);
    System.out.println("Wybierz potwora, którego chcesz zaatakować: ");
    int action = getAction();
    while (true) {
      if (action > monsters.size() || action < 1) {
        System.out.println("Wybierz odpowiedni numer!");
        action = getAction();
      } else {
        break;
      }
    }
    return action;
  }

  public void showMenu() {
    System.out.println("1. Atak");
    System.out.println("2. Obrona");
    System.out.println("3. Użyj przedmiotu");
    System.out.println("4. Ucieczka");
    int action = getAction();
    listener.onActionClick(action);
  }
}
