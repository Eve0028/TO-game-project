package pk.rpgame.model;

public abstract class WorldEntity {
    private String name;

    public WorldEntity(String name) {
        this.name = name;
    }

    public String toString() {
        return this.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
