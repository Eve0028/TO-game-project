package pk.rpgame.controller;

import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.items.ArmorItem;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.items.Potion;
import pk.rpgame.model.items.UsableItem;
import pk.rpgame.model.living.Hero;
import pk.rpgame.view.FightView;
import pk.rpgame.view.GeneralMenu;
import pk.rpgame.view.Map;
import pk.rpgame.view.MenuClickListener;

import java.util.List;

public class GeneralMenuController implements MenuClickListener {

    private GeneralMenu generalMenu;
    private Hero heroGeneralControler;

    private Room room;

    private Map map;

    private LevelMap activeLevelMapController;
    private GameEngine gameEngineController;
    private FightView fightViewHelp;

    private ExplorationController explorationControllerHelp;

    public GeneralMenuController(Hero heroGeneralControler, Room room, Map map, LevelMap activeLevelMapController, GameEngine gameEngineController) {
        this.heroGeneralControler = heroGeneralControler;
        this.room = room;
        this.map = map;
        this.activeLevelMapController = activeLevelMapController;
        this.gameEngineController = gameEngineController;
    }

    public void initView() {
        generalMenu.setListener(this::onActionClick);
        generalMenu.showMenu();
    }


    public void showInventroy() {
        if (heroGeneralControler.getItems().isEmpty()) {
            generalMenu.printNothingMessageInInventory();
            generalMenu.showMenu();
        } else {
            generalMenu.printInventory(heroGeneralControler.getItems());
            generalMenu.showMenu();
        }

        generalMenu.showMenu();
    }

    public void useHealthPotion() {
        List<Item> itemInventory=heroGeneralControler.getItems();
        int itemChoose=fightViewHelp.getItemChoice(itemInventory);
        Item item=itemInventory.get(itemChoose);
        if(item.getClass()== Potion.class && (heroGeneralControler.getHealth()<heroGeneralControler.getMaxHealth())){
            ((Potion) item).use(heroGeneralControler);
            if(heroGeneralControler.getHealth()>heroGeneralControler.getMaxHealth()){
                double healthDifference=heroGeneralControler.getHealth()-heroGeneralControler.getMaxHealth();
                heroGeneralControler.setHealth(heroGeneralControler.getHealth()-healthDifference);
            }
            fightViewHelp.printHeroHealth(heroGeneralControler);
            fightViewHelp.showMenu();
        } else if (heroGeneralControler.getHealth()==heroGeneralControler.getMaxHealth()) {
            fightViewHelp.fullHpMessage();
            fightViewHelp.showMenu();
        }else{
            fightViewHelp.wrongChoice();
            generalMenu.showMenu();
        }

        generalMenu.showMenu();
    }

    public void backToExploration(){
        explorationControllerHelp=new ExplorationController(heroGeneralControler,map,room,activeLevelMapController, gameEngineController);
        explorationControllerHelp.initView();

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
                //TODO save game to file
                break;
            case 4:
                // TODO exit game
                break;
            case 5:
                backToExploration();
            default:
                generalMenu.wrongChoice();
        }
    }
}



