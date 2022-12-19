package pk.rpgame.model.items;

public class ArmorItem extends Item {
    private double defense;

    public ArmorItem(String name, double defense) {
        super(name);
        this.defense = defense;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\narmor: " + this.getDefense();
    }
}
