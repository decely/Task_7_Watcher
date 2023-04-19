package com.example.task_7;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    //параметры фигуры - приватные поля

    protected Color color;

    protected double x, y;

    // объявление абстрактных методов

    abstract double area();

    abstract void draw( GraphicsContext gr);
    //abstract void draw( GraphicsContext gr, int x, int y);

    // конструктор

    public Shape(double x, double y, Color color) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Shape() {
        //this.color = Color.BLACK;
        this.x = 1;
        this.y = 1;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

// реализация методов

    public void setColor(Color color) {

        this.color=color;     }
}
