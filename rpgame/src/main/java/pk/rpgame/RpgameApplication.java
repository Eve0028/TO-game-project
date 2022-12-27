package pk.rpgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.builder.FirstLevelBuilder;
import pk.rpgame.view.Map;
import java.util.List;

@SpringBootApplication
public class RpgameApplication {
    public static void main(String[] args) throws Exception {
        // SpringApplication.run(RpgameApplication.class, args);

        // Build first LevelMap
        FirstLevelBuilder levelBuilder = new FirstLevelBuilder();
        levelBuilder.reset();
        levelBuilder.setRooms();
        levelBuilder.setMonsters();
        levelBuilder.setMapItems();
        LevelMap lv1Map = levelBuilder.getLevelMap();

        // Set Hero in first Room
        Room activeRoom = lv1Map.getRooms().get(0);
        activeRoom.enterRoom();

        // Create Map to visualise map on screen
        final int mapSize = 5;
        Map mapVision = new Map(lv1Map, mapSize, mapSize);

        // Add mapVision to be updated about Room's state changes
        lv1Map.subscribe(mapVision);
        mapVision.show();

        // Get the nearest rooms from the room where Hero is currently located
        List<Room> nearestRooms = activeRoom.getNearestRooms();

        // Room travel test
        int howManySteps = 0;
        while (!nearestRooms.isEmpty() && howManySteps < 5) {
            // Get last nearest room from the room where Hero is currently located
            Room nextRoom = nearestRooms.get(nearestRooms.size() - 1);
            // Put Hero in nextRoom
            lv1Map.changeRooms(activeRoom, nextRoom);
            activeRoom = nextRoom;

            mapVision.show();
            // Get the nearest rooms from the room where Hero is currently located
            nearestRooms = activeRoom.getNearestRooms();

            howManySteps++;
        }
    }
}
