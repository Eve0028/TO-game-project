package pk.rpgame.controller;

public abstract class Controller {

    private GameEngine gameEngine;

    public Controller(GameEngine gameEngine) {
        this.gameEngine=gameEngine;
    }


    public  abstract void  initView();

}
