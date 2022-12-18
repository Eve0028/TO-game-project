package pk.rpgame.model.living;

import pk.rpgame.model.items.Item;
import pk.rpgame.model.living.state.HealthStatus;

import java.util.List;

public class Lizard extends Monster {
    public Lizard(String name, int level, double strength, double health, double maxHealth, List<Item> items, HealthStatus liveState) {
        super(name, level, strength, health, maxHealth, items, liveState);
    }

    @Override
    public double dealDamage() {
        if (this.getHealth() < this.getMaxHealth() / 2) {
            return this.getStrength() * 1.2;
        }
        return super.dealDamage();
    }
}
