package com.company.chapter_12;


import com.company.BaseSolution;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

//************************************************************************
// KochSnowflake.java Author: Lewis/Loftus
//
// Demonstrates the use of recursion to draw a fractal.
//************************************************************************
public class PP12_12 extends Application
{
    private final static int MIN_ORDER = 1;
    private final static int MAX_ORDER = 8;
    private int order;
    private Button up, down;
    private Text orderText;
    private Polygon triangle;
    /*/---------------------------------------------------------
    -----------
    // Displays two buttons that control the order of the
        fractal
    // shown in the pane below the buttons.
    //---------------------------------------------------------
    -----------*/
    public void start(Stage primaryStage)
    {
//        Button upImage = new Button();
        up = new Button("+");
//        up.setGraphic(new ImageView(upImage));
        up.setOnAction(this::processUpButtonPress);
        Button downImage = new Button();
        down = new Button("-");
//        down.setGraphic(new ImageView(downImage));
        down.setOnAction(this::processDownButtonPress);
        down.setDisable(true);
        order = 1;
        orderText = new Text("Order: 1");
        HBox toolbar = new HBox();
        toolbar.setStyle("-fx-background-color: darksalmon");
        toolbar.setAlignment(Pos.CENTER);
        toolbar.setPrefHeight(50);
        toolbar.setSpacing(40);
        toolbar.getChildren().addAll(up, orderText, down);
        triangle = new Polygon();
//        triangle.setStrokeWidth(1);
//        triangle.setFill(Paint.valueOf("BLACK"));
        triangle.setStrokeWidth(8.0);
        triangle.getPoints().addAll(200.0,0.0, 400.0,200.0,0.0,200.0);
        VBox root = new VBox();
        root.setStyle("-fx-background-color: white");
        root.getChildren().addAll(toolbar, triangle);
        Scene scene = new Scene(root, 400, 450);
        primaryStage.setTitle("Koch Snowflake");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /*/---------------------------------------------------------
    -----------
    // Increments the fractal order when the up button is
        pressed.
    // Disables the up button if the maximum order is reached.
    //---------------------------------------------------------
    -----------*/
    public void processUpButtonPress(ActionEvent event)
    {
        order++;
        orderText.setText("Order: " + order);
        triangle.getPoints().addAll(0.0, 0.0);
        down.setDisable(false);
        if (order == MAX_ORDER)
            up.setDisable(true);
    }
    /*/---------------------------------------------------------
    -----------
    // Decrements the fractal order when the down button is
        pressed.
    // Disables the down button if the minimum order is
                reached.
    //---------------------------------------------------------
    -----------*/
    public void processDownButtonPress(ActionEvent event)
    {
        order--;
        orderText.setText("Order: " + order);

        up.setDisable(false);
        if (order == MIN_ORDER) {
            down.setDisable(true);
            triangle.getPoints().clear();
            triangle.getPoints().addAll(200.0,0.0, 400.0,200.0,0.0,200.0);

        }
    }
}