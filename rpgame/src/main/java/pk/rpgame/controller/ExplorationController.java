package pk.rpgame.controller;

import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.items.ArmorItem;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.living.Hero;
import pk.rpgame.view.*;

import java.util.List;

public class ExplorationController extends Controller implements MenuClickListener{


    private static ExplorationView explorationView;
    private Room room;

    private Map map;

    private Hero heroControler;

    private LevelMap activeLevelMapController;
    private GameEngine gameEngineController;

    private GeneralMenuController generalMenuHelp;




    public ExplorationController(Hero hero,Map map, Room currentRoom,LevelMap activeLevelMap,GameEngine gameEngine) {
        super(gameEngine);
        this.explorationView = new ExplorationView();
        this.room = currentRoom;
        this.heroControler=hero;
        this.map=map;
        this.activeLevelMapController=activeLevelMap;


    }

    public void setGameEngineController(GameEngine gameEngineController) {
        this.gameEngineController = gameEngineController;
    }

    @Override
    public void initView() {
        explorationView.printRoomDescription(room);
        explorationView.setListener(this::onActionClick);
        explorationView.showMenu();
    }

    @Override
    public void onActionClick(int num) {
        switch (num){
            case 1:
                findItem();
                break;
            case 2:
                nextRoom();
                break;
            case 3:
                showMap();
                break;
            case 4:
                showGeneralMenu();
                break;
            default:
                explorationView.wrongChoice();
        }
    }

    public  void findItem(){
        List<Item> itemList=room.getItems();
        if(itemList.isEmpty()){
            //move to the view
            System.out.println("Nothing found");
        }else{
            PickUpItems isPickedUp=explorationView.pickUpItems();
            if(isPickedUp==PickUpItems.PICK_UP){
                for (Item item:
                     itemList) {
                     if (item.getClass()==ArmorItem.class) {
                        for (Item item2:
                             heroControler.getItems()) {
                            if (item2.getClass() == ArmorItem.class) {
                                heroControler.removeItem(item2);
                            }
                        }
                    }

                     heroControler.addItem(item);
                }
            }else {
                    explorationView.showMenu();
            }
        }
    }

    public void nextRoom(){
        //user choose next room
        List<Room> nearestRoom=room.getNearestRooms();
        int nextDestination=explorationView.getRoomChoice(nearestRoom);
        // new room for hero
        Room nextRoom=nearestRoom.get(nextDestination-1);
        activeLevelMapController.changeRooms(room,nextRoom);
        room=nextRoom;
        //gameEngineController.changeStateControler();
    }


    public void showMap(){
        map.show();
        explorationView.showMenu();
    }

    public void showGeneralMenu(){
            generalMenuHelp=new GeneralMenuController(heroControler,room,map,activeLevelMapController,gameEngineController);
            generalMenuHelp.initView();
    }


}
