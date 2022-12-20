package pk.rpgame.model.factory.item;
import pk.rpgame.model.items.Potion;

public class PotionItemsFactory extends ItemsFactory {
    private double health;

    @Override
    public Potion getObject() throws Exception {
        return new Potion(super.getItemName(), this.health);
    }

    @Override
    public Class<?> getObjectType() {
        return Potion.class;
    }

    public double getHealth() {
        return health;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}
