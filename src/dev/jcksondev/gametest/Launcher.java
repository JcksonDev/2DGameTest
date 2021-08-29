package dev.jcksondev.gametest;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("2D Game", 1920, 1080);
        game.start();
    }
}