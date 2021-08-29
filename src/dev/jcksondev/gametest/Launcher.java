package dev.jcksondev.gametest;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("2D Game", 500, 500);
        game.start();
    }
}