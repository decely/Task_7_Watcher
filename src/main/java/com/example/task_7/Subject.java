package com.example.task_7;

public interface Subject {
    public void notifyAllObserver();
    public void attach(IObserver obs);
    public void detach(IObserver obs);

    void stop() throws InterruptedException;
}
