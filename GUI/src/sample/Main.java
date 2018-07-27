package sample;

public class Main {

    private LiDAR lidar;

    private Main() {
        this.lidar = new LiDAR("COM3");
        lidar.connect();
    }

    public static void main(String[] args) {
        new Main();
    }
}
