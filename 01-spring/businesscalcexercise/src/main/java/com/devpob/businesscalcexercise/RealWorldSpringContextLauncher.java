package com.devpob.businesscalcexercise;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.devpob.businesscalcexercise.services.BusinessCalculationService;

@Configuration
@ComponentScan("com.devpob.businesscalcexercise.services")
public class RealWorldSpringContextLauncher {
    public static void main(String[] args) {
        try (
            var context = new AnnotationConfigApplicationContext(RealWorldSpringContextLauncher.class)
        ) {
            
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("\n" + context.getBean(BusinessCalculationService.class).findMax());
            

        } catch (Exception e) {
            System.out.println("\n" + e.getClass().getSimpleName());
            System.out.println("\n" + e.getMessage());
        }
    }
}