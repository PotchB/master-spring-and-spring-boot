package com.devpob.learnspringframework02.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleSpringContextLauncher {
    public static void main(String[] args) {
        try (
            var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncher.class)
        ) {
        
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        } catch (Exception e) {
            System.out.println
            
             ("\n" + e.getClass().getSimpleName() + "\n");
            System.out.println(e.getMessage());
        }
    }
}