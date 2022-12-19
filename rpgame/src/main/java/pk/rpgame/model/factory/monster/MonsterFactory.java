package pk.rpgame.model.factory.monster;

import org.springframework.beans.factory.FactoryBean;
import pk.rpgame.model.items.Item;
import pk.rpgame.model.living.Monster;
import pk.rpgame.model.living.state.HealthStatus;

import java.util.List;

public abstract class MonsterFactory implements FactoryBean<Monster> {
    private int factoryId;
    private String monsterName;

    private int monsterLevel;
    private double monsterStrength;
    private double monsterHealth;
    private double monsterMaxHealth;

    private List<Item> monsterItems;
    // private double defense;
    private HealthStatus monsterLiveState;

    @Override
    public abstract Monster getObject() throws Exception;

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

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterLevel() {
        return monsterLevel;
    }

    public void setMonsterLevel(int monsterLevel) {
        this.monsterLevel = monsterLevel;
    }

    public double getMonsterStrength() {
        return monsterStrength;
    }

    public void setMonsterStrength(double monsterStrength) {
        this.monsterStrength = monsterStrength;
    }

    public double getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(double monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public double getMonsterMaxHealth() {
        return monsterMaxHealth;
    }

    public void setMonsterMaxHealth(double monsterMaxHealth) {
        this.monsterMaxHealth = monsterMaxHealth;
    }

    public List<Item> getMonsterItems() {
        return monsterItems;
    }

    public void setMonsterItems(List<Item> monsterItems) {
        this.monsterItems = monsterItems;
    }

    public HealthStatus getMonsterLiveState() {
        return monsterLiveState;
    }

    public void setMonsterLiveState(HealthStatus monsterLiveState) {
        this.monsterLiveState = monsterLiveState;
    }
}
