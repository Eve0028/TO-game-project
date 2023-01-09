package pk.rpgame.controller;

import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.items.Potion;
import pk.rpgame.model.items.UsableItem;
import pk.rpgame.model.living.Hero;
import pk.rpgame.model.singleton.AccessSaveFile;
import pk.rpgame.view.GeneralMenu;
import pk.rpgame.view.Map;
import pk.rpgame.view.MenuClickListener;

import java.util.List;

public class GeneralMenuController extends Controller implements MenuClickListener {

    private GeneralMenu generalMenu;
    private Hero heroControler;

    private Room room;

    private Room previousRoom;

    private Map map;

    private LevelMap activeLevelMap;




    public GeneralMenuController(Hero heroController, Room room, Room previousRoom,Map map, LevelMap activeLevelMap,
                                 GameEngine gameEngine) {
        super(gameEngine);
        this.generalMenu= new GeneralMenu();
        this.heroControler = heroController;
        this.room = room;
        this.map = map;
        this.activeLevelMap = activeLevelMap;
        this.previousRoom=previousRoom;

    }

    public GeneralMenuController(GameEngine gameEngine) {
        super(gameEngine);
    }

    public void initView() {
        generalMenu.setListener(this);
        generalMenu.showMenu();
    }

    @Override
    public void onActionClick(int num) {
        switch (num) {
            case 1:
                showInventroy();
                break;
            case 2:
                useHealthPotion();
                break;
            case 3:
                saveGame();
                break;
            case 4:
                endGame();
                break;
            case 5:
                backToExploration();
            default:
                generalMenu.wrongChoice();
                generalMenu.showMenu();
        }
    }


    public void showInventroy() {
        List<Item> heroInventory=heroControler.getItems();
        if (heroInventory.isEmpty()) {
            generalMenu.printNothingMessageInInventory();
            generalMenu.showMenu();
        } else {
            generalMenu.printInventory(heroControler.getItems());
            generalMenu.showMenu();
        }

        generalMenu.showMenu();
    }
    public void useHealthPotion() {
        List<Item> itemInventory=heroControler.getItems();
        if(itemInventory.isEmpty()){
            generalMenu.printNothingMessageInInventory();
            generalMenu.showMenu();
        } else if (heroControler.getHealth()==heroControler.getMaxHealth()) {
            generalMenu.fullHpMessage();
            generalMenu.showMenu();
        }

        int itemChoose=generalMenu.getItemChoice(itemInventory)-1;
        Item item=itemInventory.get(itemChoose);
        if(item.getClass()== Potion.class && (heroControler.getHealth()<heroControler.getMaxHealth())){
            ((Potion) item).use(heroControler);
            if(heroControler.getHealth()>heroControler.getMaxHealth()){
                double healthDifference=heroControler.getHealth()-heroControler.getMaxHealth();
                heroControler.setHealth(heroControler.getHealth()-healthDifference);
            }
            generalMenu.printHeroHealth(heroControler);
            generalMenu.showMenu();
        }  else if (!itemInventory.contains(UsableItem.class)) {
            generalMenu.printNothingMessageInInventory();
            generalMenu.showMenu();
        } else{
            generalMenu.wrongChoice();
            generalMenu.showMenu();
        }
    }

    public void backToExploration(){
        gameEngine.changeStateControler(new ExplorationController(heroControler,map,room,previousRoom,
                activeLevelMap,gameEngine));

    }

    public void saveGame(){
        AccessSaveFile.getInstance().saveData(heroControler.getName(),heroControler.getHealth(),
                heroControler.getStrength(),heroControler.getItems());
        generalMenu.showMenu();
    }

    public void endGame(){
        generalMenu.endGameMessage();
        System.exit(0);
    }


}



