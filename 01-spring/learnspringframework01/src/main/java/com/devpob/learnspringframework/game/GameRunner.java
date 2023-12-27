package com.devpob.learnspringframework.game;

public class GameRunner {
    private GameConsole game;
    
    public GameRunner(GameConsole game) {
        this.game = game;
    }
    
    public void run() {
        System.out.println("\nRunning game: " + game.getClass().getSimpleName() + "\n");
        this.game.up();
        this.game.down();
        this.game.left();
        this.game.right();
    }
}
