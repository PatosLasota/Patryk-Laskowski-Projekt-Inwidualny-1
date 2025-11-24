package com.kodilla;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ScoreDisplay extends Label {
    public ScoreDisplay() {
        setTextFill(Color.WHITE);
        setFont(new Font("Arial", 20));
        setStyle("-fx-font-weight: bold;");
        updateScore(0, 0);
    }

    public void updateScore(int circleWins, int crossWins) {
        setText("Kółko: " + circleWins + " | Krzyżyk: " + crossWins);
    }
}