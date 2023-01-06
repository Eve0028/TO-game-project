package pk.rpgame.controller;

import pk.rpgame.model.Room;

public abstract class ControllerState {
  public static IController getController(Room currentRoom) {
    if (currentRoom.getCreatures().isEmpty()) {
      return new ExplorationController();
    } else {
      return new FightController();
    }
  }
}
