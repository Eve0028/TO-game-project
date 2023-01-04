package pk.rpgame.model.builder;

public interface LevelMapBuilder {
    void reset();
    void setRooms();
    // void setNearestRooms();
    void setMonsters() throws Exception; // Monster's items are set in Monsters Factories
    void setMapItems() throws Exception;
}
