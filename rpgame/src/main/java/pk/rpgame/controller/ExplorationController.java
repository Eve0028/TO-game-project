package pk.rpgame.controller;

import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.items.ArmorItem;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.items.Potion;
import pk.rpgame.model.living.Hero;
import pk.rpgame.view.*;

import java.util.List;

public class ExplorationController implements IController {


    private static ExplorationView explorationView;
    private Room room;

    private Map map;

    private Hero heroControler;

    private LevelMap activeLevelMapController;



    public ExplorationController(Hero hero,Map map, Room currentRoom,LevelMap activeLevelMap) {
        this.explorationView = new ExplorationView();
        this.room = currentRoom;
        this.heroControler=hero;
        this.map=map;
        this.activeLevelMapController=activeLevelMap;
    }


    @Override
    public void initView() {
        explorationView.printRoomDescription(room);
        explorationView.showMenu();
        explorationView.setListener(new MenuClickListener() {
            @Override
            public void onActionClick(int action) {
                switch (action){
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
        });
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
                    if( item.getClass()== Potion.class){
                        heroControler.addItem(item);
                    } else if (item.getClass()==ArmorItem.class) {
                        heroControler.setArmor(((ArmorItem) item).getDefense());
                    }else {
                        //TODO
                        // change weapon (class weapon does not use in hero class )
                    }
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

        explorationView.showMenu();
    }


    public void showMap(){
        map.show();
        explorationView.showMenu();
    }

    public void showGeneralMenu(){
        // make general menu controller
    }

}
