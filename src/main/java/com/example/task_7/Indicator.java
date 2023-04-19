package com.example.task_7;

import javafx.scene.control.ProgressBar;

public class Indicator implements IObserver{
    ProgressBar indic = new ProgressBar();
    private double counter = 0;

    public Indicator(){
    }
    @Override
    public void update() {
        counter = counter + 0.1;
        indic.setProgress(counter);
        if (counter > 1)
            counter = 0;
    }
}
