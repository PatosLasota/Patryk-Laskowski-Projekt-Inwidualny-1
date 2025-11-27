package com.kodilla;

import javafx.scene.media.AudioClip;

import java.awt.*;

public class SoundManager {

    private static final String CLICK_SOUND = "file:/Users/patrwlas/dev/Patryk-Laskowski-Projekt-Inwidualny-1/src/main/resources/click.mp3";
    private static final String WIN_SOUND = "file:/Users/patrwlas/dev/Patryk-Laskowski-Projekt-Inwidualny-1/src/main/resources/win.mp3";
    private static final String DRAW_SOUND = "file:/Users/patrwlas/dev/Patryk-Laskowski-Projekt-Inwidualny-1/src/main/resources/draw.mp3";

    public static void playClickSound() {
        try {
            AudioClip sound = new AudioClip(CLICK_SOUND);
            sound.play();
        } catch (Exception e) {
            System.out.println("Nie można odtworzyć dźwięku kliknięcia");
        }
    }

    public static void playWinSound() {
        try {
            AudioClip sound = new AudioClip(WIN_SOUND);
            sound.play();
        } catch (Exception e) {
            System.out.println("Nie można odtworzyć dźwięku wygranej");
        }
    }

    public static void playDrawSound() {
        try {
            AudioClip sound = new AudioClip(DRAW_SOUND);
            sound.play();
        } catch (Exception e) {
            System.out.println("Nie można odtworzyć dźwięku remisu");
        }
    }

    public static void playBeep() {
        try {
            Toolkit.getDefaultToolkit().beep();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}