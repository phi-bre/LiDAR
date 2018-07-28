package sample;

public class Measurement {

    private int distance, strength;
    private double angle;

    public Measurement(int distance, int strength, double angle) {
        this.distance = distance;
        this.strength = strength;
        this.angle = angle;
    }

    public int getDistance() {
        return distance;
    }

    public int getStrength() {
        return strength;
    }

    public double getAngle() {
        return angle;
    }
}
