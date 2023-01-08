package pk.rpgame.controller;

public abstract class Controller {

    protected GameEngine gameEngine;

    public Controller(GameEngine gameEngine) {
        this.gameEngine=gameEngine;
    }


    public  abstract void  initView();

}
