package pk.rpgame.model;

import pk.rpgame.model.state.HealthStatus;

import java.util.List;

public abstract class LivingEntity extends WorldEntity {
    private int level;
    private double strength;
    private double health;

    private List<Item> items;
    // private double defense;
    private HealthStatus liveState;

    public LivingEntity(String name, int level, double strength, double health, List<Item> items, HealthStatus liveState) {
        super(name);
        this.level = level;
        this.strength = strength;
        this.health = health;
        // this.defense = defense;
        this.items = items;
        this.liveState = liveState;
    }

    public abstract double dealDamage();

    public abstract void receiveDamage(double damage);

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

//    public double getDefense() {
//        return defense;
//    }
//
//    public void setDefense(double defense) {
//        this.defense = defense;
//    }

    public HealthStatus getLiveState() {
        return liveState;
    }

    public void setLiveState(HealthStatus liveState) {
        this.liveState = liveState;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nstrength: " + this.getStrength()
                + "\nhealth: " + this.getHealth();
        // + "\ndefense: " + defense;
    }
}
