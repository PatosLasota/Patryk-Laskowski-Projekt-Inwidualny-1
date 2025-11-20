package com.kodilla;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private Image imagebacck = new Image("file:src/main/resources/background.png");
    private Image circle = new Image("file:src/main/resources/Candy_Circle.png");
    private Image cross = new Image("file:src/main/resources/Candy_Cross.png");
    private GridPane marks = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100,100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imagebacck, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50,50,60,50));
        grid.setHgap(50);
        grid.setVgap(50);
        grid.setBackground(background);

        grid.add(marks,0,0);

        Mark mark = new Mark(circle, cross);

        mark.addMark(marks, 0,0);
//        mark.addMark(marks, 1,0);
//        mark.addMark(marks, 2,0);
//        mark.addMark(marks, 0,1);

        Scene scene = new Scene(grid, 481,1024, Color.BLACK);

        primaryStage.setTitle("Blackjack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}