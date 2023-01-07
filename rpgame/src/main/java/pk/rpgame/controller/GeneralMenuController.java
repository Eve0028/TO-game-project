package pk.rpgame.controller;

import pk.rpgame.model.items.ArmorItem;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.items.Potion;
import pk.rpgame.model.items.UsableItem;
import pk.rpgame.model.living.Hero;
import pk.rpgame.view.FightView;
import pk.rpgame.view.GeneralMenu;
import pk.rpgame.view.MenuClickListener;

import java.util.List;

public class GeneralMenuController {

    private GeneralMenu generalMenu;
    private Hero heroGeneralControler;

    private FightView fightViewHelp;

    public GeneralMenuController(Hero heroGeneral) {
        this.generalMenu = new GeneralMenu();
        this.heroGeneralControler = heroGeneral;
    }



    public void initView() {
        generalMenu.showMenu();
        generalMenu.setListener(new MenuClickListener() {
            @Override
            public void onActionClick(int action) {
                switch (action) {
                    case 1:
                        showInventroy();
                        break;
                    case 2:
                        useHealthPotion();
                        break;
                    case 3:
                        //TODO save to file
                        break;

                }
            }
        });
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




}



