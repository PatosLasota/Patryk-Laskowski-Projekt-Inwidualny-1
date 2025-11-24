//package com.kodilla;
//
//import javafx.scene.Node;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.GridPane;
//
//public class Mark extends Node {
//    private boolean isCircleTurn = true;
//    private Image circle;
//    private  Image cross;
//
//    public Mark(Image circle, Image cross) {
//        this.circle = circle;
//        this.cross = cross;
//    }
//
//    public void addMark(GridPane grid, int row, int col){
//        ImageView markImage;
//        if(isCircleTurn){
//            markImage = new ImageView(circle);
//        } else{
//            markImage = new ImageView(cross);
//        }
//        markImage.setFitHeight(100);
//        markImage.setFitWidth(100);
//        markImage.setPreserveRatio(true);
//
//        grid.add(markImage,col,row);
//        isCircleTurn = !isCircleTurn;
//    }
//    public void resetTurn(){
//        isCircleTurn = true;
//    }
//
//    @Override
//    public Node getStyleableNode() {
//        return super.getStyleableNode();
//    }
//}
package com.kodilla;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class Mark {
    private final Image circleImage;
    private final Image crossImage;

    public Mark(Image circleImage, Image crossImage) {
        this.circleImage = circleImage;
        this.crossImage = crossImage;
    }

    public void addMark(GridPane grid, int row, int col, boolean isCircle) {
        ImageView markImage = new ImageView(isCircle ? circleImage : crossImage);
        markImage.setFitHeight(90);
        markImage.setFitWidth(90);
        markImage.setPreserveRatio(true);

        FadeTransition ft = new FadeTransition(Duration.millis(100), markImage);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), markImage);
        scaleTransition.setFromX(0.4);
        scaleTransition.setFromY(0.4);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setInterpolator(Interpolator.EASE_BOTH);

        ScaleTransition finalScale = new ScaleTransition(Duration.millis(200), markImage);
        finalScale.setToX(1.0);
        finalScale.setToY(1.0);

        scaleTransition.play();

        scaleTransition.setOnFinished(event -> finalScale.play());
        grid.add(markImage, col, row);
    }
}
