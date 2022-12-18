package pk.rpgame.model.items;

import pk.rpgame.model.living.LivingEntity;

public abstract class UsableItem extends Item {
    public UsableItem(String name) {
        super(name);
    }

    public abstract void use(LivingEntity entity);
}
