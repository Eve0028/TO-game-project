package pk.rpgame.controller;

import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.living.Hero;
import pk.rpgame.view.MainMenu;
import pk.rpgame.view.Map;
import pk.rpgame.view.MenuClickListener;

public class MainMenuController extends Controller implements MenuClickListener {

  private static MainMenu mainMenu = new MainMenu();

  private Hero hero;

  private Room room;

  private Map map;

  private LevelMap levelMap;

  public MainMenuController(Hero hero, Map map, Room currentRoom, LevelMap levelMap,
      GameEngine gameEngine) {
    super(gameEngine);
    this.hero = hero;
    this.room = currentRoom;
    this.map = map;
    this.levelMap = levelMap;
  }

  @Override
  public void onActionClick(int num) {
    switch (num) {
      case 1:
        chooseName();
        break;
      case 2:
        hallOfFamePrinter();
        break;
      case 3:
        endGame();
        break;
      default:
        mainMenu.wrongChoice();
        mainMenu.showMenu();
    }

  }

  @Override
  public void initView() {
    mainMenu.setListener(this);
    mainMenu.showMenu();
  }

  private void hallOfFamePrinter() {
    mainMenu.printHallOfFame();
    mainMenu.showMenu();
  }

  private void endGame() {
    mainMenu.endGameMessage();
    System.exit(0);
  }

  private void chooseName() {
    String heroName = mainMenu.chooseHeroName();
    hero.setName(heroName);
    gameEngine
        .changeStateControler(new ExplorationController(hero, this.map, this.room, null, levelMap, gameEngine));
  }

}