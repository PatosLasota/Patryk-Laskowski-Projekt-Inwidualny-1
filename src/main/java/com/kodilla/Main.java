package com.kodilla;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private Image imagebacck = new Image("file:src/main/resources/background.png");
    private Image circle = new Image("file:src/main/resources/Candy_Circle.png");
    private Image cross = new Image("file:src/main/resources/Candy_Cross.png");

    private boolean isCircleTurn = true;
    private boolean[][] occupied = new boolean[3][3];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100,100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imagebacck, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setBackground(background);
        grid.setHgap(22);
        grid.setVgap(23);

        Mark mark = new Mark(circle, cross);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Pane cell = new Pane();
//                cell.setStyle("-fx-border-color: white; " +
//                        "-fx-border-width: 2px; " +
//                        "-fx-background-color: rgba(255, 255, 255, 0.1);");
                cell.setPrefSize(100, 100);
                final int row = i;
                final int col = j;

                cell.setOnMouseClicked(event -> {
                    if(!occupied[row][col]){
                        mark.addMark(grid, row, col);
                        occupied[row][col] = true;
                        isCircleTurn = !isCircleTurn;
                    }
                });

                grid.add(cell, j, i);
            }
        }
        grid.setPadding(new Insets(180,0 , 0, 70));

        Scene scene = new Scene(grid, 481,1024, Color.BLACK);

        primaryStage.setTitle("TictacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}