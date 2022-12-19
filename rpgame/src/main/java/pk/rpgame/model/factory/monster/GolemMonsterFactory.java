package pk.rpgame.model.factory.monster;

import pk.rpgame.model.living.Golem;

public class GolemMonsterFactory extends MonsterFactory {

    @Override
    public Golem getObject() throws Exception {
        return new Golem(super.getMonsterName(), super.getMonsterLevel(),
                super.getMonsterStrength(), super.getMonsterHealth(),
                super.getMonsterMaxHealth(), super.getMonsterItems(),
                super.getMonsterLiveState());
    }

    @Override
    public Class<?> getObjectType() {
        return Golem.class;
    }
}
