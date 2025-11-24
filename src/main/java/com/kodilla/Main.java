package com.kodilla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private Image backgroundImage = new Image("file:src/main/resources/background.png");
    private Image circleImage = new Image("file:src/main/resources/Candy_Circle.png");
    private Image crossImage = new Image("file:src/main/resources/Candy_Cross.png");

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        ScoreDisplay scoreDisplay = new ScoreDisplay();
        GameBoard gameBoard = new GameBoard(backgroundImage, circleImage, crossImage, game, scoreDisplay);
        Scene scene = new Scene(gameBoard, 481, 1024, Color.BLACK);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}