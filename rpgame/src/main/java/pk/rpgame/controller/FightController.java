package pk.rpgame.controller;

import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.items.Potion;
import pk.rpgame.model.items.UsableItem;
import pk.rpgame.model.living.Hero;
import pk.rpgame.model.living.LivingEntity;
import pk.rpgame.model.living.Monster;
import pk.rpgame.view.FightView;
import pk.rpgame.view.Map;
import pk.rpgame.view.MenuClickListener;

import java.util.List;

public class FightController extends Controller implements MenuClickListener {

    private static FightView fightViewController;
    private Room room;

    private Room previousRoom;

    private Map map;

    private Hero heroControler;

    private LevelMap activeLevelMapController;



    public FightController(GameEngine gameEngine, Hero hero, Map map, Room currentRoom, Room previousRoom,
                           LevelMap activeLevelMap) {
        super(gameEngine);
        this.fightViewController = new FightView();
        this.room = currentRoom;
        this.heroControler = hero;
        this.map = map;
        this.activeLevelMapController = activeLevelMap;
        this.previousRoom=previousRoom;

    }
    public void setGameEngineController(GameEngine gameEngineController) {
        this.gameEngine = gameEngineController;
    }
    

    @Override
    public void initView() {
        fightViewController.printRoomDescription(room);
        fightViewController.printEnemies(room.getCreatures());
        fightViewController.setListener(this);
        fightViewController.showMenu();
    }


    @Override
    public void onActionClick(int num) {
        switch (num) {
            case 1:
                attack();
                break;
            case 2:
                defend();
                break;
            case 3:
                useItem();
                break;
            case 4:
                escape();
                break;
            default:
                fightViewController.wrongChoice();
                fightViewController.showMenu();
        }
    }

    public void endGame(){
        fightViewController.endGameMessage();
        System.exit(0);
    }

    public void attack() {
        if (heroControler.getHealth() > 0) {
        List<LivingEntity> listMonsters = room.getCreatures();

                for (LivingEntity monster :
                        listMonsters) {
                    heroControler.setHealth(heroControler.getHealth()-monster.dealDamage());
                    fightViewController.printAttackResult(monster.getName(), heroControler.getName(),
                            monster.dealDamage());
                    if (heroControler.getHealth() > 0) {
                        fightViewController.printHeroHealth(heroControler);
                    } else {
                        fightViewController.heroDeath();
                        endGame();
                        break;
                    }
                }

                int chooseMonster = fightViewController.getMonsterChoice(room.getCreatures())-1;
                Monster monster = (Monster) listMonsters.get(chooseMonster);
                if (monster.getHealth() > 0) {
                    monster.setHealth(monster.getHealth()-heroControler.dealDamage());
                    fightViewController.printAttackResult(heroControler.getName(), monster.getName(), heroControler.dealDamage());
                    if(monster.getHealth()<=0){
                        fightViewController.printMonsterDeath(monster.getName());
                        listMonsters.remove(monster);
                    }
                }


                    if(room.getCreatures().isEmpty()){
                        room.setCreatures(listMonsters);
                        System.out.println("You defeat them all!");
                        gameEngine.changeStateControler(new ExplorationController(heroControler,map,room,previousRoom,
                                activeLevelMapController,gameEngine));
                    }
                    fightViewController.showMenu();

        }else{
            fightViewController.heroDeath();

            fightViewController.endGameMessage();
            endGame();
        }
    }

    public void defend(){

                List<LivingEntity> listMonsters = room.getCreatures();
                if (listMonsters.isEmpty()) {
                    fightViewController.winRoom();
                    gameEngine.changeStateControler(new ExplorationController(heroControler,map,room,previousRoom,
                            activeLevelMapController,gameEngine));
                }else{
                    for (LivingEntity monster :
                            listMonsters) {
                        fightViewController.blockHero(monster);
                        fightViewController.printHeroHealth(heroControler);
                    }

                    fightViewController.showMenu();

                }
            }



    public void useItem(){
        List<Item> itemInventory=heroControler.getItems();
        if(itemInventory.isEmpty()){
            fightViewController.printNothingMessageInInventory();
            fightViewController.showMenu();
        }
        int itemChoose=fightViewController.getItemChoice(itemInventory)-1;
        Item item=itemInventory.get(itemChoose);
        if(item.getClass()== Potion.class && (heroControler.getHealth()<heroControler.getMaxHealth())){
                ((Potion) item).use(heroControler);
                if(heroControler.getHealth()>heroControler.getMaxHealth()){
                    double healthDifference=heroControler.getHealth()-heroControler.getMaxHealth();
                    heroControler.setHealth(heroControler.getHealth()-healthDifference);
                }
                itemInventory.remove(item);
                heroControler.setItems(itemInventory);
                fightViewController.printHeroHealth(heroControler);
                fightViewController.showMenu();
        } else if (heroControler.getHealth()==heroControler.getMaxHealth()) {
            fightViewController.fullHpMessage();
            fightViewController.showMenu();
        } else if (!itemInventory.contains(UsableItem.class)) {
                fightViewController.printNothingMessageInInventory();
                fightViewController.showMenu();
        } else{
            fightViewController.wrongChoice();
            fightViewController.showMenu();
        }
    }

    public void escape(){
        activeLevelMapController.changeRooms(room,previousRoom);
        gameEngine.changeStateControler(new ExplorationController(heroControler,map,previousRoom,
                activeLevelMapController,gameEngine));
    }



}
