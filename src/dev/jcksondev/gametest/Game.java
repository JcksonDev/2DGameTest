package dev.jcksondev.gametest;

import dev.jcksondev.gametest.display.Display;
import dev.jcksondev.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{
    private Display display;
    private String title;
    private int width, height;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage testImage;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init() {
        display = new Display(title, width, height);
        testImage = ImageLoader.loadImage("/textures/testimage.png");
    }

    private void tick() {}

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0, width, height); // Clear screen
        // Start drawing

        

        // End drawing
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        while (running) {
            tick();
            render();
        }

        stop();
    }

    public synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
