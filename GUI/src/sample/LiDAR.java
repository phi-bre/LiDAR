package sample;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LiDAR {

    public static final int BAUDRATE = 115200;
    public static final String COM = "COM3";

    private SerialPort comPort;
    private OutputStream os;
    private InputStream is;
    private boolean connected;

    private Thread thread;

    public LiDAR() {
        thread = new Thread(() -> {
            while (connected) {
                try {
                    if (is.available() > 0) {
                        byte[] buffer = new byte[6];
                        is.read(buffer, 0, buffer.length);

                        int d = ((buffer[0] & 0xFF) << 8) | (buffer[1] & 0xFF);
                        int s = ((buffer[2] & 0xFF) << 8) | (buffer[3] & 0xFF);
                        int a = ((buffer[4] & 0xFF) << 8) | (buffer[5] & 0xFF);

                        System.out.println("Distance: " + d + " Strength: " + s + " Angle: " + a);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void connect() {
        comPort = SerialPort.getCommPorts()[0];
        comPort.setBaudRate(BAUDRATE);
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
        is = comPort.getInputStream();
        os = comPort.getOutputStream();
        connected = true;
        thread.start();
    }

    public void disconnect() {
        comPort.closePort();
        connected = false;
    }

    public Measurement readMeasurement() {
        /*try {
            for (int i = 0; i < 100; i++) {
                os.write(2);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        return null;
    }

    public void getMeasurementStream() {

    }

}
