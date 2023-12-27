package com.devpob.learnspringframework02.examples.g1;

import java.util.Arrays;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

// @Component
@Named      
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
        return this.dataService;
    }
    
    // @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }
}

interface DataService { }

// @Component
@Named
class MongoDBDataService implements DataService { }

/** 
 * CDI is just an alternative to creating beans and setting up dependency injections
 */
@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println("\n" + context.getBean(BusinessService.class).getDataService().getClass().getSimpleName() + "\n");

        } catch (Exception e) {
            System.out.println("\n" + e.getClass().getSimpleName());
            System.out.println("\n" + e.getMessage());
        }
    }
}