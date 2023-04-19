package com.example.task_7;

import javafx.scene.control.Label;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class Signal  implements IObserver {
    Text txt = new Text();
    private double counter = 0;
    private int counterload = 0;
    public Signal(){
    }
    @Override
    public void update() {
        counter = counter + 0.1;
        if (counter > 1) {
            counter = 0;
            counterload++;
        }
        txt.setText("Загружено "+ counterload + " раз");

    }
}

