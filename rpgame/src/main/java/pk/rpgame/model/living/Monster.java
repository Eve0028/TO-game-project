package pk.rpgame.model.living;

import pk.rpgame.Visitor;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.living.state.HealthStatus;

import java.util.List;

// TODO:
// In controls:
// Take ready-made monsters from the board (flyweight) and copy them (prototype),
// and if they don't exist yet - create and add to the board (factory method).

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
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
