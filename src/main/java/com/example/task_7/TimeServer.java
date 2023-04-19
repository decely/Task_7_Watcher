package com.example.task_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimeServer implements Subject{
    private Timer timer;
    private TimerTask task;
    private int timeState = 0;

    List<IObserver> observers = new ArrayList<IObserver>();



    private void tick(){
        timeState++;
        notifyAllObserver();
    }
    public TimeServer(){
        this.timer = new Timer();
        task = new TimerTask(){
            public void run(){
                tick();
            }
        };
        timer.schedule(task, 100, 1000);
    }


    @Override
    public void notifyAllObserver() {
        for (IObserver observer : observers) {
            observer.update();

        }
        System.out.println("Something: "+ timeState);
    }

    @Override
    public void attach(IObserver obs) {
        observers.add(obs);

    }

    @Override
    public void detach(IObserver obs) {
        observers.remove(obs);
    }

    //@Override
    public void stop() throws InterruptedException {
        this.timer.cancel();
    }

    public void start() {
        this.timer = new Timer();
        task = new TimerTask(){
            public void run(){
                tick();
            }
        };
        timer.schedule(task, 100, 1000);
    }
}

