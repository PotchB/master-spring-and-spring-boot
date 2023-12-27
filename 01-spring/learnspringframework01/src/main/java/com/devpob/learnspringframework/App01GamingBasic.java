package com.devpob.learnspringframework;

import com.devpob.learnspringframework.game.GameRunner;
import com.devpob.learnspringframework.game.Pacman;

public class App01GamingBasic {
    public static void main(String[] args) {
        // var game = new MarioGame();
        // var game = new SuperContra();
        
        // 1. Object creation
        var game = new Pacman();
        
        // 2. Object creation + Wiring of Dependencies
        var gameRunner = new GameRunner(game);
        // GameRunner is dependent on game object to run
        // So we say, game object is a dependency of GameRunner
        // And here, we are injecting the game object into or wiring the game dependency into the GameRunner

        gameRunner.run();

        // Right now, the creation of objects and wiring of dependencies are completely managed by us
        // These objects are created in the JVM

        // However, in the real-world projects, there are thousands of dependency injections happening
        // So instead of managing, wiring, and injecting these dependencies ourselves manually, we can make use of the Spring Framework to do that

        // Inside JVM, a Spring Context will be created to manage these objects
    }
}