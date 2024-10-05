package org.example.chatterbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FMXL/loginWindow.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 600,400);

        scene.getStylesheets().add(getClass().getResource("/FMXL/Style/login.css").toExternalForm());

        stage.setTitle("Chatterbox");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}