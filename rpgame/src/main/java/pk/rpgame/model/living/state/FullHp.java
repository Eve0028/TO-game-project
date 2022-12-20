package pk.rpgame.model.living.state;

public class FullHp extends HealthStatus {
    @Override
    public String getDescription() {
        return "in full strength";
    }

    @Override
    public double attack() {
        return 0;
    }

    @Override
    public double defense() {
        return 0;
    }

    @Override
    public String toString() {
        return "FullHp";
    }
}
