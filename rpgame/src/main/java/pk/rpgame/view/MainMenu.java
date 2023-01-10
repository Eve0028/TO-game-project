package pk.rpgame.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
  private MenuClickListener listener;

  public void setListener(MenuClickListener listener) {
    this.listener = listener;
  }

  private int getAction() {
    Scanner keyboard = new Scanner(System.in);
    Integer action = keyboard.nextInt();
    return action;
  }

  public void wrongChoice() {
    System.out.println("Wrong choice!!");
  }

  public void endGameMessage() {
    System.out.println("Shutdown a game!");
  }

  public String chooseHeroName() {
    System.out.println("Enter hero name: ");

    Scanner keyboard = new Scanner(System.in);
    String name = keyboard.nextLine();
    return name;
  }

  public void printHallOfFame() {
    try {
      List<String> lines = Files.readAllLines(Paths.get("data.txt"));
      for (String line : lines) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void showMenu() {
    System.out.println("1. Start a new game");
    System.out.println("2. Show Hall of Fame");
    System.out.println("3. Exit game");
    int action = getAction();
    listener.onActionClick(action);
  }
}
