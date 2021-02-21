package com.company.chapter_12;

import javafx.scene.shape.Polygon;

public class Triangle extends Polygon {
    private double topX = 400.0;
    private double topY = 0.0;
    private double leftX = 0.0;
    private double leftY = 200.0;
    private double rightX = 0;

    public Triangle(double... points) {
        super(200.0,0.0, 400.0,200.0,0.0,200.0);

    }


}
