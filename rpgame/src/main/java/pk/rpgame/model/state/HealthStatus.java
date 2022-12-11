package pk.rpgame.model.state;

import pk.rpgame.model.LivingEntity;

// TODO:
// Create all statuses

public abstract class HealthStatus {
    protected LivingEntity creature;

    // Instead of, or in addition to giving a health points, you can describe entity state
    public abstract String getDescription();
    public abstract double attack();
    public abstract double defense();
}
