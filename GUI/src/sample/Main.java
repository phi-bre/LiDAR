package sample;

public class Main {

    private LiDAR lidar;

    private Main() {
        this.lidar = new LiDAR();
        this.lidar.connect();
        this.lidar.readMeasurement();
    }

    public static void main(String[] args) {
        new Main();
    }
}
