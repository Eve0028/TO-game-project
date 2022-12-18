package pk.rpgame.model.living;

import pk.rpgame.model.items.Item;
import pk.rpgame.model.living.state.HealthStatus;

import java.util.List;

public class Golem extends Monster {

    public Golem(String name, int level, double strength, double health, double maxHealth, List<Item> items, HealthStatus liveState) {
        super(name, level, strength, health, maxHealth, items, liveState);
    }

    @Override
    public void receiveDamage(double damage) {
        if (this.getHealth() > this.getMaxHealth() / 2) {
            double additionalHealth = 0.2 * this.getHealth();
            if (damage > additionalHealth) {
                this.setHealth(this.getHealth() - damage);
                return;
            }
            return;
        }
        super.receiveDamage(damage);
    }
}
