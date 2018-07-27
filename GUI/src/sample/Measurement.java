package sample;

public class Measurement {

    private int distance, signal;
    private double angle;

    public Measurement(int distance, int signal, double angle) {
        this.distance = distance;
        this.signal = signal;
        this.angle = angle;
    }

    public int getDistance() {
        return distance;
    }

    public int getSignal() {
        return signal;
    }

    public double getAngle() {
        return angle;
    }
}
