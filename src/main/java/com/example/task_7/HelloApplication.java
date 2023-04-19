package com.example.task_7;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("Iterator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        //Scene iterator = new Scene(fxmlLoader1.load(), 700, 400);
    }

    public static void main(String[] args) {
        launch();
    }
}