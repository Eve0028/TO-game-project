package pk.rpgame.controller;

import pk.rpgame.model.living.Hero;
import pk.rpgame.view.GeneralMenu;
import pk.rpgame.view.MenuClickListener;

public class GeneralMenuController implements IController{

    private GeneralMenu generalMenu;
    private Hero heroGeneralControler;

    public GeneralMenuController(Hero heroGeneral) {
        this.generalMenu = new GeneralMenu();
        this.heroGeneralControler=heroGeneral;
    }


    @Override
    public void initView() {
        generalMenu.showMenu();
        generalMenu.setListener(new MenuClickListener() {
            @Override
            public void onActionClick(int action) {
                switch (action){
                    case 1:
                        showInventroy();
                }
            }
        });
    }


    public void showInventroy(){
        if(heroGeneralControler.getItems().isEmpty()){
            generalMenu.printNothingMessageInInventory();
            generalMenu.showMenu();
        }else {
            generalMenu.printInventory(heroGeneralControler.getItems());
            generalMenu.showMenu();
        }
    }


}
