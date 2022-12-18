package pk.rpgame.model.living.state;

public class FullHp extends HealthStatus {
    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public double attack() {
        return 0;
    }

    @Override
    public double defense() {
        return 0;
    }
}
