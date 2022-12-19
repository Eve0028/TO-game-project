package pk.rpgame.model.factory.item;

import org.springframework.beans.factory.FactoryBean;
import pk.rpgame.model.items.Item;

public abstract class ItemsFactory implements FactoryBean<Item> {
    private int factoryId;
    private String itemName;

    @Override
    public abstract Item getObject() throws Exception;

    @Override
    public abstract Class<?> getObjectType();

    @Override
    public boolean isSingleton() {
        return false;
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
