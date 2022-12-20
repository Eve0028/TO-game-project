package pk.rpgame.model.items;

import pk.rpgame.Visitor;

public class Weapon extends Item{
    private double attack;

    public Weapon(String name, double attack) {
        super(name);
        this.attack = attack;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public String toString() {
        return super.toString()
                + " [attack: " + this.getAttack() + "]";
    }
}
