package pk.rpgame.controller;

import pk.rpgame.model.Room;
import pk.rpgame.model.WorldEntity;
import pk.rpgame.model.living.Hero;

public abstract class ControllerState {
  public static IController getController(Hero hero,WorldEntity worldEntity, Room currentRoom) {
    if (currentRoom.getCreatures().isEmpty()) {
      return new ExplorationController(hero,worldEntity,currentRoom);
    } else {
      return new FightController();
    }
  }
}
