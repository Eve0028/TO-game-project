package pk.rpgame.model.living;

import pk.rpgame.model.items.Item;
import pk.rpgame.model.WorldEntity;
import pk.rpgame.model.items.UsableItem;
import pk.rpgame.model.living.state.HealthStatus;

import java.util.List;

public abstract class LivingEntity extends WorldEntity {
    private int level;
    private double strength;
    private double health;
    private double maxHealth;

    private List<Item> items;
    private HealthStatus liveState;

    public LivingEntity(String name, int level, double strength, double health, double maxHealth, List<Item> items, HealthStatus liveState) {
        super(name);
        this.level = level;
        this.strength = strength;
        // We can always render an injured LivingEntity
        this.health = health;
        this.maxHealth = maxHealth;
        this.items = items;
        this.liveState = liveState;
    }

    public abstract double dealDamage();

    public abstract void receiveDamage(double damage);

    public void useItem(UsableItem item) {
        item.use(this);
    }

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
        if (health > this.maxHealth) {
            this.health = maxHealth;
            return;
        }
        this.health = health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public HealthStatus getLiveState() {
        return liveState;
    }

    public void setLiveState(HealthStatus liveState) {
        this.liveState = liveState;
    }

    @Override
    public String toString() {
        return super.toString() + " ["
                + "level: " + this.getLevel() + ", "
                + "strength: " + this.getStrength() + ", "
                + "health: " + this.getHealth() + ", "
                + "maxHealth: " + this.getMaxHealth() + ", "
                + "liveState: " + this.getLiveState() + ", "
                + "items: (" + this.getItems() + "), ";
    }
}
