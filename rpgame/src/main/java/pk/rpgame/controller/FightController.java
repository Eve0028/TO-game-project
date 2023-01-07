package pk.rpgame.controller;

import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.items.Potion;
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

    private Map map;

    private Hero heroControler;

    private LevelMap activeLevelMapController;
    private GameEngine gameEngineController;


    public FightController(GameEngine gameEngine, Hero hero, Map map, Room currentRoom, LevelMap activeLevelMap) {
        super(gameEngine);
        this.fightViewController = new FightView();
        this.room = currentRoom;
        this.heroControler = hero;
        this.map = map;
        this.activeLevelMapController = activeLevelMap;

    }

    @Override
    public void initView() {
        fightViewController.printRoomDescription(room);
        fightViewController.printEnemies(room.getCreatures());
        fightViewController.setListener(this::onActionClick);
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
        }
    }

    public void attack() {
        if (heroControler.getHealth() > 0) {
        List<LivingEntity> listMonsters = room.getCreatures();
        if (listMonsters.isEmpty()) {
            System.out.println("You defeat them all!");
        } else {
                for (LivingEntity monster :
                        listMonsters) {
                    heroControler.receiveDamage(monster.dealDamage());
                    fightViewController.printAttackResult(monster.getName(), heroControler.getName(), monster.dealDamage());
                    if (heroControler.getHealth() > 0) {
                        fightViewController.printHeroHealth(heroControler);
                    } else {
                        fightViewController.heroDeath();
                        break;
                    }
                }

                int chooseMonster = fightViewController.getMonsterChoice(room.getCreatures());
                Monster monster = (Monster) listMonsters.get(chooseMonster);
                if (monster.getHealth() > 0) {
                    monster.receiveDamage(heroControler.dealDamage());
                    fightViewController.printAttackResult(heroControler.getName(), monster.getName(), heroControler.dealDamage());
                    listMonsters.set(chooseMonster,monster);
                } else {
                    fightViewController.printMonsterDeath(monster.getName());
                    listMonsters.remove(monster);
                }
                    fightViewController.showMenu();
            }
        }else{
            fightViewController.heroDeath();
        }
    }

    public void defend(){
        if (heroControler.getHealth() > 0){
            List<LivingEntity> listMonsters = room.getCreatures();
            if (listMonsters.isEmpty()) {
                fightViewController.winRoom();
            }else{
                for (LivingEntity monster :
                        listMonsters) {
                    fightViewController.blockHero(monster);
                    fightViewController.printHeroHealth(heroControler);
                }

            }
        }else{
            fightViewController.heroDeath();
        }
    }

    public void useItem(){
        List<Item> itemInventory=heroControler.getItems();
        int itemChoose=fightViewController.getItemChoice(itemInventory);
        Item item=itemInventory.get(itemChoose);
        if(item.getClass()== Potion.class && (heroControler.getHealth()<heroControler.getMaxHealth())){
                ((Potion) item).use(heroControler);
                if(heroControler.getHealth()>heroControler.getMaxHealth()){
                    double healthDifference=heroControler.getHealth()-heroControler.getMaxHealth();
                    heroControler.setHealth(heroControler.getHealth()-healthDifference);
                }
                fightViewController.printHeroHealth(heroControler);
                fightViewController.showMenu();
        } else if (heroControler.getHealth()==heroControler.getMaxHealth()) {
            fightViewController.fullHpMessage();
            fightViewController.showMenu();
        }else{
            fightViewController.wrongChoice();
            fightViewController.showMenu();
        }
    }

    public void escape(){
        //TODO change state controler, back to the previous room
    }

}
