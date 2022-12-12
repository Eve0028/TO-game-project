package pk.rpgame.menu;

import java.util.Scanner;

public class ExplorationMenu implements IMenu {
  public void showMenu() {
    System.out.println("1. Eksploruj pomieszczenie");
    System.out.println("2. Przejdź do następnego pokoju");
    System.out.println("3. Wróć do poprzedniego pokoju");
    System.out.println("4. Pokaż mapę");
    System.out.println("5. Pokaż menu");
    Scanner keyboard = new Scanner(System.in);
    int action = keyboard.nextInt();
    this.clickMenu(action);
  }

  public void clickMenu(int action /* Hero, Room[] */) {
    // Menu menu = new Menu();
    switch (action) {
      case 1:
        // Room[1].explore();
        break;
      case 2:
        // Hero.walkToRoom(Room[2]);
        break;
      case 3:
        // Hero.walkToRoom(Room[0]);
        break;
      case 4:
        // menu.showMap();
        break;
      case 5:
        // menu.showMenu();
        break;
      default:
        System.out.println("Użyj poprawnego klawisza!");
    }
  }
}