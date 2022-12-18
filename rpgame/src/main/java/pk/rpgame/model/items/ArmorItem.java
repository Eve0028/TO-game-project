package pk.rpgame.model.items;

public class ArmorItem extends Item {
    private final double defense;

    public ArmorItem(String name, double defense) {
        super(name);
        this.defense = defense;
    }

    public double getDefense() {
        return defense;
    }
}
