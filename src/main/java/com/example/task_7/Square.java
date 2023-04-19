package com.example.task_7;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    @Override
    double area() {
        return 0;
    }

    public Square(double x, double y, Color color) {
        super(x, y, color);
    }
    @Override
    void draw(GraphicsContext gr) {
        gr.setStroke(color);
        gr.setFill(color);
        gr.setLineWidth(1);
        gr.strokeRect(x, y, 10, 10);
        gr.fillRect(x, y, 10, 10);
    }
}
