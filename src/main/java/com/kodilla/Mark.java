package com.kodilla;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Mark extends Node {
    private boolean isCircleTurn = true;
    private Image circle;
    private  Image cross;

    public Mark(Image circle, Image cross) {
        this.circle = circle;
        this.cross = cross;
    }

    public void addMark(GridPane grid, int row, int col){
        ImageView markImage;
        if(isCircleTurn){
            markImage = new ImageView(circle);
        } else{
            markImage = new ImageView(cross);
        }
        markImage.setFitHeight(100);
        markImage.setFitWidth(100);
        markImage.setPreserveRatio(true);

        grid.add(markImage,col,row);
        isCircleTurn = !isCircleTurn;
    }
    public void resetTurn(){
        isCircleTurn = true;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
