package com.springdemo.businesscalculationservice;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springdemo.businesscalculationservice.services.BusinessCalculationService;
import com.springdemo.businesscalculationservice.services.DataService;
import com.springdemo.businesscalculationservice.services.MySQLDataService;

@Configuration
@ComponentScan
public class BusinessCalculationServiceApp {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BusinessCalculationServiceApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);   

            System.out.println("\n" + context.getBean(BusinessCalculationService.class).findMax());
            
            DataService dataService = new MySQLDataService();
            context.getBean(BusinessCalculationService.class).setDataService(dataService);
            System.out.println("\n" + context.getBean(BusinessCalculationService.class).findMax());

            System.out.println("\nData Service: " + context.getBean(BusinessCalculationService.class).getDataService().getClass().getSimpleName());
        }
    }
}
