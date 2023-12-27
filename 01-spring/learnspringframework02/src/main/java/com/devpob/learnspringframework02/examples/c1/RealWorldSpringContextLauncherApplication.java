package com.devpob.learnspringframework02.examples.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.devpob.learnspringframework02.examples.c1.services.BusinessCalculationService;
import com.devpob.learnspringframework02.examples.c1.services.DataService;
import com.devpob.learnspringframework02.examples.c1.services.MySQLDataService;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);   

            System.out.print("\n" + context.getBean(BusinessCalculationService.class).getDataService().getClass().getSimpleName() + ": ");
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
            DataService dataService = new MySQLDataService();
            context.getBean(BusinessCalculationService.class).setDataService(dataService);
            System.out.print("\n" + context.getBean(BusinessCalculationService.class).getDataService().getClass().getSimpleName() + ": ");
            System.out.println(context.getBean(BusinessCalculationService.class).findMax() + "\n");

        } catch (Exception e) {
            System.out.println("\n" + e.getClass().getSimpleName() + "\n");
        }
    }
}