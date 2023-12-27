package com.devpob.learnspringframework;
import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.devpob.learnspringframework.game.GameConsole;
import com.devpob.learnspringframework.game.GameRunner;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            // For GameConsole
            context.getBean(GameConsole.class).up();
            context.getBean(GameConsole.class).down();
            context.getBean(GameConsole.class).left();
            context.getBean(GameConsole.class).right();

            // For GameRunner
            context.getBean(GameRunner.class).run();

            System.out.println("\n" + context.getBean(GameConsole.class).getClass().getSimpleName());
            System.out.println("\n" + context.getBean(GameRunner.class).getClass().getSimpleName() + "\n");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
