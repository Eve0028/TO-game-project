package pk.rpgame.menu;

import java.awt.*;
import java.util.Scanner;

public class GeneralMenu implements IMenu {
  public void showMenu() {
    System.out.println("1. Rozwiń statystyki");
    System.out.println("2. Zapisz grę");
    System.out.println("3. Wyświetl statystyki");
    System.out.println("4. Wyświetl ekwipunek");
    System.out.println("5. Wyświetl mapę");
    System.out.println("6. Użyj eliksiru");
    Scanner keyboard = new Scanner(System.in);
    int action = keyboard.nextInt();
    this.clickMenu(action);
  }

  public void clickMenu(int action /* Hero */) {
    switch (action) {
      case 1:
        // TODO: functionality to buy stats
        break;
      case 2:
        // TODO: functionality to save game
        break;
      case 3:
        System.out.println("Pozostałe zdrowie: " /* + Hero.getHealth() */);
        System.out.println("Siła: " /* + Hero.getStrength() */);
        System.out.println("Obrona: " /* + Hero.getDefense() */);
        System.out.println("Pancerz: " /* + Hero.getArmor() */);
        System.out.println("Wytrzymałość: " /* + Hero.getStamina() */);
        break;
      case 4:
        System.out.println(/* Hero.getItems() */);
        break;
      case 5:
        this.showMap();
        break;
      case 6:
        // Hero.usePotion();
        break;
      default:
        System.out.println("Użyj poprawnego klawisza!");
    }
  }

  private void showMap(/*Room, LevelMap*/) {
    Point currentLocation; // = Room.getLocationOnMap();
    //TODO: change map for currentLocation to be distinguishable
    // LevelMap.toString();
  }
}
