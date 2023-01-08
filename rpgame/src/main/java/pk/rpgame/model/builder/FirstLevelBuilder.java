package pk.rpgame.model.builder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pk.rpgame.model.IntPoint;
import pk.rpgame.model.LevelMap;
import pk.rpgame.model.Room;
import pk.rpgame.model.factory.FactoryBeanConfiguration;
import pk.rpgame.model.factory.item.PotionItemsFactory;
import pk.rpgame.model.factory.monster.LizardMonsterFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class FirstLevelBuilder implements LevelMapBuilder {
    private LevelMap levelMap;
    private List<Room> roomList;

    ApplicationContext context = new AnnotationConfigApplicationContext(FactoryBeanConfiguration.class);
    PotionItemsFactory strongPotionFactory = context.getBean("&strongPotionItem", PotionItemsFactory.class);
    LizardMonsterFactory golemFactory = context.getBean("&lizardMonsterWithPotion", LizardMonsterFactory.class);

    public FirstLevelBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.roomList = new LinkedList<>();
        this.levelMap = new LevelMap("First Level", roomList);
    }

    @Override
    public void setRooms() {
        final int mapSize = 5;
        // All possible Room's Points
        IntPoint[][] allRooms = new IntPoint[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                allRooms[i][j] = new IntPoint(i, j);
            }
        }

        // Create Room's Point with its "roommates"
        // Use only Room's Points in certain LevelMap
        TreeMap<IntPoint, List<IntPoint>> listRoomsLocation = new TreeMap<>();
        listRoomsLocation.put(allRooms[0][0], List.of(allRooms[1][0]));
        listRoomsLocation.put(allRooms[1][0], List.of(allRooms[0][0], allRooms[1][1]));
        listRoomsLocation.put(allRooms[1][1], List.of(allRooms[1][0]));

        for (IntPoint mainRoomPoint : listRoomsLocation.keySet()) {
            // Add room with monsters and items to roomList
            roomList.add(new Room("room" + mainRoomPoint.toString(), new ArrayList<>(), new ArrayList<>(), mainRoomPoint));
        }

        // Set Nearest Rooms to all Rooms
        for (Room room : roomList) {
            room.setNearestRooms(roomList.stream()
                    .filter(r -> listRoomsLocation.get(room.getLocationOnMap()).contains(r.getLocationOnMap()))
                    .toList());
        }
    }

//    @Override
//    public void setNearestRooms() {
//
//    }

    @Override
    public void setMonsters() throws Exception {
       /* for (Room room : this.roomList) {
            for (int m = 0;m < 3; m++) {
                room.addCreature(golemFactory.getObject());
            }
        }*/
    }

    @Override
    public void setMapItems() throws Exception {
        for (Room room : this.roomList) {
                room.addItem(strongPotionFactory.getObject());
        }
    }

    public LevelMap getLevelMap() {
        return this.levelMap;
    }
}
