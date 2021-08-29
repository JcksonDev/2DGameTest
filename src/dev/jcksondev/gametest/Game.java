package dev.jcksondev.gametest;

import dev.jcksondev.gametest.display.Display;

public class Game {
    private Display display;
    private String title;
    private int width, height;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        display = new Display(title, width, height);
    }
}
