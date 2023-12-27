package com.devpob.learnspringframework02.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready");
    }

    @PostConstruct      //  Use this annotation to run this method as soon as the dependencies are wired in
    public void initialize() {
        someDependency.getReady();  // this is your database connection
    }

    @PreDestroy     // Use this annotation to do something before an app is terminated or before a bean is removed from your context
    public void cleanup() {     //  If you have any connections to the database or things like that, you can close them down in cleanup().
        System.out.println("Releasing Database Resource");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("Acquiring Database Connection");  //  This can be a connection to a database when you'd want to get data from the db
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationLauncherApp {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationLauncherApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("\n\n" + e.getMessage());
        }
    }
}