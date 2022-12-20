package pk.rpgame.model.factory.monster;

import pk.rpgame.model.living.Lizard;

public class LizardMonsterFactory extends MonsterFactory {

    @Override
    public Lizard getObject() throws Exception {
        return new Lizard(super.getMonsterName(), super.getMonsterLevel(),
                super.getMonsterStrength(), super.getMonsterHealth(),
                super.getMonsterMaxHealth(), super.getMonsterItems(),
                super.getMonsterLiveState());
    }

    @Override
    public Class<?> getObjectType() {
        return Lizard.class;
    }
}
