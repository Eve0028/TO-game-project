package pk.rpgame.model.living;

import pk.rpgame.Visitor;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.living.state.HealthStatus;

import java.util.List;


public class Monster extends LivingEntity {

    public Monster(String name, int level, double strength, double health, double maxHealth, List<Item> items, HealthStatus liveState) {
        super(name, level, strength, health, maxHealth, items, liveState);
    }

    @Override
    public double dealDamage() {
        return this.getStrength();
    }

    @Override
    public void receiveDamage(double damage) {
        this.setHealth(getHealth()-damage);
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
