package pk.rpgame.menu;

import java.util.Scanner;

public class FightMenu implements Menu {
  public void showMenu() {
    System.out.println("1. Użyj broni");
    System.out.println("2. Użyj eliksiru");
    System.out.println("3. Obrona");
    System.out.println("4. Ucieczka");
    Scanner keyboard = new Scanner(System.in);
    int action = keyboard.nextInt();
    this.clickMenu(action);
  }

  public void clickMenu(int action /* Hero */) {
    switch (action) {
      case 1:
        // Hero.dealDamage();
        break;
      case 2:
        // Hero.drinkPotion();
        break;
      case 3:
        // Hero.defend();
        break;
      case 4:
        // Hero.escape();
        break;
      default:
        System.out.println("Użyj poprawnego klawisza!");
    }
  }
}
