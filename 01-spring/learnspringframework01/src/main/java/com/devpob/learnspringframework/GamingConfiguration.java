package com.devpob.learnspringframework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.devpob.learnspringframework.game.GameConsole;
import com.devpob.learnspringframework.game.GameRunner;
import com.devpob.learnspringframework.game.Pacman;

@Configuration
public class GamingConfiguration {
    
    @Bean
    public GameConsole gameConsole() {
        return new Pacman();
    }

    @Bean
    public GameRunner gameRunner(GameConsole gameConsole) {     //  Here, we're taking the existing bean called gameConsole and wiring it in gameRunner bean
        return new GameRunner(gameConsole);
    }
}