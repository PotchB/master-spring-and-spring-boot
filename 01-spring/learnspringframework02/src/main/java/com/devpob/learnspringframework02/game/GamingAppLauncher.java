package com.devpob.learnspringframework02.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/* 
@Configuration
class GameConfig {

    // Moved inside GamingAppLauncher class
    @Bean
    public GameConsole game() {
        return new Pacman();
    }

    @Bean
    public GameRunner gameRunner(GameConsole game) {
        System.out.println("Parameter: " + game.getClass().getSimpleName());
        return new GameRunner(game);
    }
}
 */


@Configuration
@ComponentScan("com.devpob.learnspringframework02.game")
public class GamingAppLauncher {
    /*  Replace this with @Component in Pacman class 
    @Bean
    public GameConsole game() {
        return new Pacman();
    } */

    /*  Replace this with @Component in GameRunner class
    @Bean
    public GameRunner gameRunner(GameConsole game) {
        System.out.println("Parameter: " + game.getClass().getSimpleName());
        return new GameRunner(game);
    } */

    public static void main(String[] args) {
        // var game = new Mario();
        // var game = new SuperContra();
        // var game = new Pacman();
        // var gameRunner = new GameRunner(game);
        // gameRunner.run();
        try (var context = new AnnotationConfigApplicationContext(GamingAppLauncher.class)) {
            context.getBean(GameConsole.class).up();
            context.getBean(GameRunner.class).run();

            // System.out.println("\n\n");
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("\n" + e.getClass().getSimpleName() + "\n");
            System.out.println(e.getMessage());
        }
    }
}