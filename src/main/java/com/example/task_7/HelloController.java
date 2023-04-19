package com.example.task_7;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.security.Provider;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public VBox box;
    public VBox box2;
    public TextField lbl;
    public Canvas can;
    public VBox box3;
    Signal signal = new Signal();
    Indicator indicator = new Indicator();
    ImageLoop imageLoop = new ImageLoop();
    FactoryLoop factoryLoop = new FactoryLoop();
    TimeServer timeServer = new TimeServer();
    ShapeFactory shapeFactory = new ShapeFactory();

    public ImageCollection imgs = new ImageCollection("Pic");
    public Iterator iter_main = imgs.getIterator();
    public ImageView Image1;
    public Timeline timeline = new Timeline();
    public boolean Serverstarted = true;

    public void start(Stage primaryStage){
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 1440, 720);
        primaryStage.setTitle("Iterator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void handle(ActionEvent actionEvent) {
        System.out.println("Start ImageLoop");
        timeServer.attach(imageLoop);
    }
    public void onStop(ActionEvent actionEvent) {
        System.out.println("Stop ImageLoop");
        timeServer.detach(imageLoop);
    }

    public void LoopStart(ActionEvent actionEvent) {
        System.out.println("Start FactoryLoop");
        timeServer.attach(factoryLoop);
    }

    public void LoopEnd(ActionEvent actionEvent) {
        System.out.println("Stop FactoryLoop");
        timeServer.detach(factoryLoop);
    }

    public void onHelloButtonClickStart(ActionEvent actionEvent) {
        System.out.println("Start count");
        timeServer.attach(signal);
        timeServer.attach(indicator);
    }

    public void onHelloButtonClickStop(ActionEvent actionEvent) {
        System.out.println("Stop count");
        timeServer.detach(signal);
        timeServer.detach(indicator);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        box.getChildren().add(signal.txt);
        box.getChildren().add(indicator.indic);

        box2.getChildren().add(imageLoop.Image1);

        box3.getChildren().add(factoryLoop.canvas);

        factoryLoop.canvas.setHeight(100);
        factoryLoop.canvas.setWidth(100);
        //start(Stage);
        indicator.indic.setProgress(0);
        signal.txt.setText("Загружено 0 раз");

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(iter_main.hasNext()){
                    Image name = (Image)iter_main.next();
                    Image1.setImage(name);

                }
            }
        }));
    }


    public void NextImage(ActionEvent actionEvent) {
    }

    public void OnServStop(ActionEvent actionEvent) throws InterruptedException {
        timeServer.stop();
        Serverstarted = false;
    }

    public void OnServStart(ActionEvent actionEvent) {
        if (Serverstarted == false)
        {
            timeServer.start();
            Serverstarted = true;
        }
        else
        {
            System.out.println("Server already started!");
        }
    }
}

