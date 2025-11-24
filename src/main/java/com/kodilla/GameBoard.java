package com.kodilla;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class GameBoard extends GridPane {
    private final Game game;
    private final ScoreDisplay scoreDisplay;
    private final Image circleImage;
    private final Image crossImage;

    public GameBoard(Image backgroundImage, Image circleImage, Image crossImage, Game game, ScoreDisplay scoreDisplay) {
        this.game = game;
        this.scoreDisplay = scoreDisplay;
        this.circleImage = circleImage;
        this.crossImage = crossImage;

        setupBoard(backgroundImage);
        createCells();
        add(scoreDisplay, 0, 3, 3, 1);
    }

    private void setupBoard(Image backgroundImage) {
        setHgap(22);
        setVgap(23);
        setPadding(new Insets(181, 0, 0, 70));

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, backgroundSize);
        setBackground(new Background(backgroundImg));
    }

    private void createCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Pane cell = createCell(i, j);
                add(cell, j, i);
            }
        }
    }

    private Pane createCell(int row, int col) {
        Pane cell = new Pane();
        cell.setPrefSize(100, 100);
        cell.setOnMouseClicked(event -> handleCellClick(row, col));
//        cell.setStyle("-fx-border-color: white; " +
//                "-fx-border-width: 2px; " +
//                "-fx-background-color: rgba(255, 255, 255, 0.1);");
        return cell;
    }

    private void handleCellClick(int row, int col) {
        if (game.makeMove(row, col)) {
            addMark(row, col);
            checkGameState();
        }
    }

    private void addMark(int row, int col) {
        Mark mark = new Mark(circleImage, crossImage);
        mark.addMark(this, row, col, !game.isCircleTurn());
    }

    private void checkGameState() {
        int result = game.checkWin();
        if (result > 0) {
            scoreDisplay.updateScore(game.getCircleWins(), game.getCrossWins());
            DialogManager.showWinMessage(result == 1 ? "Kółko" : "Krzyżyk");
            resetBoard();
        } else if (game.isBoardFull()) {
            DialogManager.showDrawMessage();
            resetBoard();
        }
    }

    private void resetBoard() {
        getChildren().clear();
        game.resetBoard();
        createCells();
        add(scoreDisplay, 0, 3, 3, 1);
    }
}