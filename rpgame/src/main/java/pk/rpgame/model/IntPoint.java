package pk.rpgame.model;

import java.util.Comparator;

public class IntPoint implements Comparable<IntPoint> {
    private int x;
    private int y;

    public IntPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public IntPoint() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(IntPoint o) {
        return Comparator.comparing(IntPoint::getX)
                .thenComparing(IntPoint::getY)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntPoint point = (IntPoint) o;
        return x == point.getX() && y == point.getY();
    }

    @Override
    public String toString() {
        return "[" + getX() + ", " + getY() + "]";
    }
}
