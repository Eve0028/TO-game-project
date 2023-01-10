package pk.rpgame.view;

import java.util.Scanner;

public interface IView {
  default Integer getAction() {
    Scanner keyboard = new Scanner(System.in);
    Integer action;
    while (!keyboard.hasNextInt()) {
      System.out.println("That is not a number!");
      keyboard.next();
    }
    action = keyboard.nextInt();
    return action;
  }
}
