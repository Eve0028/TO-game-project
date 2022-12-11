package pk.rpgame.model;

import pk.rpgame.model.state.HealthStatus;

import java.util.List;

// TODO:
// In controls:
// Take ready-made monsters from the board (flyweight) and copy them (prototype),
// and if they don't exist yet - create and add to the board (factory method).

public class Monster extends LivingEntity {

    public Monster(String name, int level, double strength, double health, List<Item> items, HealthStatus liveState) {
        super(name, level, strength, health, items, liveState);
    }

    @Override
    public double dealDamage() {
        return this.getStrength();
    }

    @Override
    public void receiveDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
