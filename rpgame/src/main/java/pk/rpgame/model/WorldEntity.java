package pk.rpgame.model;

import pk.rpgame.Visitor;

public abstract class WorldEntity {
    private String name;

    public WorldEntity(String name) {
        this.name = name;
    }

    public abstract void accept(Visitor visitor);

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
