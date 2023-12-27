package com.devpob.learnspringframework02.game;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    GameConsole game;

    public GameRunner(@Qualifier("SuperContraGameQualifier") GameConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("\nRunning Game: " + game.getClass().getSimpleName());
        game.up();
        game.down();
        game.left();
        game.right();
    }
}



