package pk.rpgame.model.factory.item;

import pk.rpgame.model.items.ArmorItem;

public class ArmorItemsFactory extends ItemsFactory {
    private double defense;

    @Override
    public ArmorItem getObject() throws Exception {
        return new ArmorItem(super.getItemName(), this.defense);
    }

    @Override
    public Class<?> getObjectType() {
        return ArmorItem.class;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }
}
