package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class Window extends Application {

    private Parent root;

    @FXML
    private Canvas canvas;

    public Window(String args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("LiDAR v2");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
