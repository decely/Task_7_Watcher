package com.example.task_7;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class FactoryLoop extends ShapeFactory implements  IObserver{
    Canvas canvas = new Canvas();
    private int counter = 0;
    private int counterX = 15;
    private int r,g,b = 0;
    public ShapeFactory shapeFactory = new ShapeFactory();
    public FactoryLoop() { super(); }
    @Override
    public void update() {
        Shape shape = shapeFactory.createShape(counter, Color.rgb(r, g, b));
        shape.setX(counterX);
        shape.setY(50);
        shape.draw(canvas.getGraphicsContext2D());
        counterX = counterX + 15;
        counter++;
        r = r + 30;
        if (counter == 2)
            counter = 0;
        if (counterX > 100)
            counterX = 15;
        if (r == 270){
            r = 0;
            g = g + 30;
        }
        if (g == 270){
            g = 0;
            b = b + 30;
        }
        if (b == 270){
            r = 0;
            g = 0;
            b = 0;
        }

    }
}
