package com.kodilla;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ScoreDisplay extends Label {
    public ScoreDisplay() {
        setTextFill(Color.WHITE);
        updateScore(0, 0);
    }

    public void updateScore(int circleWins, int crossWins) {
        setText("Kółko: " + circleWins + " | Krzyżyk: " + crossWins);
    }
}