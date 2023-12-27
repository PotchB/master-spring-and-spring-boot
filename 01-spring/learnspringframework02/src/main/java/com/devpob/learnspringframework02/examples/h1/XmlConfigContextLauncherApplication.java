package com.devpob.learnspringframework02.examples.h1;
import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.devpob.learnspringframework02.game.GameRunner;

public class XmlConfigContextLauncherApplication {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("./contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println();
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            
            context.getBean(GameRunner.class).run();
        } catch (Exception e) {
            System.out.println("\n" + e.getClass().getSimpleName());
            System.out.println("\n" + e.getMessage());
        }
    }
}