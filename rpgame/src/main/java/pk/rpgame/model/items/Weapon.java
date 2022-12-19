package pk.rpgame.model.items;

// TODO:
// Fill class

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
    public String toString() {
        return super.toString()
                + "\nattack damage: " + this.getAttack();
    }
}
