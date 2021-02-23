package com.company.chapter_12;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Create a new version of the TiledImages program
 * from this chapter that displays the repeated images in the
 * lower-right quadrant instead of the upper-left.
 */
public class PP12_10 extends Application
{
    private final static int MIN = 1;
    private Image image;
    private ColorAdjust monochrome;
    private SepiaTone sepia;
    private Group root;
    private final int SIZE = 900;
/*---------------------------------------------------------
-----------
// Sets up the display of a series of tiled images.
//---------------------------------------------------------
        -----------
*/
    public void start(Stage primaryStage)
    {
        image = new Image("/leaf.jpg");
        monochrome = new ColorAdjust(0, -1, 0, 0);
        sepia = new SepiaTone();
        root = new Group();
        addPictures(0, SIZE / 2);
        Scene scene = new Scene(root, SIZE, SIZE, Color.WHITE);
        primaryStage.setTitle("Tiled Images");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * sets the width and height of imageview to given size
     * @param imageView the image to fit
     * @param size size of width and height
     */
    private void fitWidthHeight(ImageView imageView, double size) {
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
    }
/*---------------------------------------------------------
-----------
    // Uses the parameter to specify the size and position of
    an image.
// Displays the image in full color, monochrome, and sepia
    tone,
// then repeats the display recursively in the upper left
    quadrant.
//---------------------------------------------------------
-----------
 */
private void addPictures(double x, double size)
    {
        ImageView colorView = new ImageView(image);
        fitWidthHeight(colorView, size);
        colorView.setX(x);
        colorView.setY(x);
        ImageView monochromeView = new ImageView(image);
        monochromeView.setEffect(monochrome);
        fitWidthHeight(monochromeView, size);
        monochromeView.setX(x + size);
        monochromeView.setY(x);
        ImageView sepiaView = new ImageView(image);
        sepiaView.setEffect(sepia);
        fitWidthHeight(sepiaView, size);
        sepiaView.setX(x);
        sepiaView.setY(x + size);
        root.getChildren().addAll(sepiaView, colorView,
                monochromeView);
        if ( size > MIN )
            addPictures(x + size, size / 2);
    }
}