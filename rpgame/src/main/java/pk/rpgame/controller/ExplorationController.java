package pk.rpgame.controller;

import pk.rpgame.model.Room;
import pk.rpgame.model.WorldEntity;
import pk.rpgame.model.items.Armor;

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

    private GeneralMenu generalMenu;

    private WorldEntity worldEntityModel;

    private Hero heroControler;



    public ExplorationController(Hero hero,WorldEntity worldEntity, Room currentRoom) {
        this.explorationView = new ExplorationView();
        this.room = currentRoom;
        this.worldEntityModel = worldEntity;
        this.heroControler=hero;
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


                }
            }
        });
    }

    public  void findItem(){
        List<Item> itemList=room.getItems();
        if(itemList.isEmpty()){
            //można przenisć do viev
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
                        // zmiana broni (klasa broń nie jest używana w hero)
                    }
                }
            }else {
                    explorationView.showMenu();
            }
        }
    }

}
