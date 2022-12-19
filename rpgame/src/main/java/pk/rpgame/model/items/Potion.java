package pk.rpgame.model.items;

import pk.rpgame.model.living.LivingEntity;

public class Potion extends UsableItem {
    private final double health;

    public Potion(String name, double health) {
        super(name);
        this.health = health;
    }

    public double getHealth() {
        return health;
    }

    @Override
    public void use(LivingEntity entity) {
        entity.setHealth(entity.getHealth() + this.health);
    }

    @Override
    public String toString() {
        return super.toString()
                + " [health: " + this.getHealth() + "]";
    }
}
