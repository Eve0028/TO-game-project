package pk.rpgame.controller;

import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.builder.FirstLevelBuilder;
import pk.rpgame.model.living.Hero;
import pk.rpgame.model.living.state.FullHp;
import pk.rpgame.view.Map;

import java.util.ArrayList;

public class GameEngine {
    private Map mapVision;
    private LevelMap activeLevelMap;
    private Room activeRoom;
    private Hero hero;

    private GameEngine gameEngine;


    private Controller controllerState;

    public GameEngine() throws Exception {


        // Initialization all object needed at the beginning of the game

        // Build first LevelMap
        FirstLevelBuilder levelBuilder = new FirstLevelBuilder();
        levelBuilder.reset();
        levelBuilder.setRooms();
        levelBuilder.setMonsters();
        levelBuilder.setMapItems();
        hero = new Hero("Janek", 1, 2.5, 100, 100, 25, new ArrayList<>(), new FullHp(), 25, 15);

        activeLevelMap = levelBuilder.getLevelMap();

        // Set Hero in first Room
        activeRoom = activeLevelMap.getRooms().get(0);
        //activeRoom.enterRoom();

        // Create Map to visualise map on screen
        final int mapSize = 5;
        mapVision = new Map(activeLevelMap, mapSize, mapSize);

        // Add mapVision to be updated about Room's state changes
        activeLevelMap.subscribe(mapVision);
        //controllerState= new FightController(gameEngine,hero,mapVision,activeRoom,activeLevelMap);
        //controllerState= new ExplorationController(hero,mapVision,activeRoom,activeLevelMap,gameEngine);
        controllerState=new GeneralMenuController(hero,activeRoom,mapVision,activeLevelMap,gameEngine);
    }

    public void startGame() throws Exception {

        // Visualise map on the screen


        // Get the nearest rooms from the room where Hero is currently located
        controllerState.initView();

/*        // Room travel test
        int howManySteps = 0;*/

        /*while (!nearestRooms.isEmpty() && howManySteps < 5) {
            // Get last nearest room from the room where Hero is currently located
            Room nextRoom = nearestRooms.get(nearestRooms.size() - 1);
            // Put Hero in nextRoom
            activeLevelMap.changeRooms(activeRoom, nextRoom);
            activeRoom = nextRoom;

            mapVision.show();
            // Get the nearest rooms from the room where Hero is currently located
            nearestRooms = activeRoom.getNearestRooms();

            howManySteps++;
        }*/
    }

    public void changeStateControler(Controller controller){
        this.controllerState=controller;
    }

}
