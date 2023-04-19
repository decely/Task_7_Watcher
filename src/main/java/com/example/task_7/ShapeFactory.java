package com.example.task_7;

import javafx.scene.paint.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.*;

public class ShapeFactory {
    private HashMap<Integer, Shape> coll = new HashMap<Integer, Shape>();
    public Shape createShape(int numberOfSides, Color color) {
        coll.put(0, new Triangle(1,1, color));
        coll.put(1, new Square(1,1, color));
        return coll.get(numberOfSides);
    }
}
