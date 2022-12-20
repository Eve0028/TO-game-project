package pk.rpgame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pk.rpgame.model.IntPoint;
import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.factory.FactoryBeanConfiguration;
import pk.rpgame.model.factory.item.PotionItemsFactory;
import pk.rpgame.model.factory.monster.LizardMonsterFactory;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.living.LivingEntity;
import pk.rpgame.view.Map;

import java.lang.reflect.Array;
import java.util.*;

@SpringBootApplication
public class RpgameApplication {
    public static void main(String[] args) throws Exception {
        // SpringApplication.run(RpgameApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(FactoryBeanConfiguration.class);
        PotionItemsFactory strongPotionFactory = context.getBean("&strongPotionItem", PotionItemsFactory.class);
        LizardMonsterFactory golemFactory = context.getBean("&lizardMonsterWithPotion", LizardMonsterFactory.class);

        final int mapSize = 5;
        // All possible rooms
        IntPoint[][] allRooms = new IntPoint[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                allRooms[i][j] = new IntPoint(i, j);
            }
        }

        // Only used Rooms in certain LevelMap
        TreeMap<IntPoint, List<IntPoint>> listRoomsLocation = new TreeMap<>();
        listRoomsLocation.put(allRooms[0][0], List.of(allRooms[1][0]));
        listRoomsLocation.put(allRooms[1][0], List.of(allRooms[0][0], allRooms[1][1]));
        listRoomsLocation.put(allRooms[1][1], List.of(allRooms[1][0]));

        List<Room> roomList = new LinkedList<>();

        for (IntPoint mainRoomPoint : listRoomsLocation.keySet()) {
            List<LivingEntity> monsters = new ArrayList<>();
            for (int m = 0; m < 3; m++) {
                monsters.add(golemFactory.getObject());
            }

            List<Item> items = new ArrayList<>();
            for (int m = 0; m < 2; m++) {
                items.add(strongPotionFactory.getObject());
            }

            roomList.add(new Room("room" + mainRoomPoint.toString(), monsters, items, mainRoomPoint));
        }

        for (Room room : roomList) {
            room.setNearestRooms(roomList.stream()
                    .filter(r -> listRoomsLocation.get(room.getLocationOnMap()).contains(r.getLocationOnMap()))
                    .toList());
        }

        // Set Hero in first Room
        Room activeRoom = roomList.get(0);
        activeRoom.enterRoom();

        LevelMap lvMap1 = new LevelMap("Level 1", roomList);

        Map mapVision = new Map(lvMap1, mapSize, mapSize);
        // Add mapVision to be updated about Room's state changes
        lvMap1.subscribe(mapVision);
        mapVision.show();

        List<Room> nearestRooms = activeRoom.getNearestRooms();

        // Room travel test
        while (!nearestRooms.isEmpty()) {
            int lastRoom = nearestRooms.size() - 1;
            Room nextRoom = nearestRooms.get(lastRoom);
            lvMap1.changeRooms(activeRoom, nextRoom);
            activeRoom = nextRoom;

            mapVision.show();
            nearestRooms = activeRoom.getNearestRooms();
        }
    }
}
