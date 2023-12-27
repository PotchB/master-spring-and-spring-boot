package com.devpob.learnspringframework02.examples.a1;
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//  This launcher is to discuss the different Dependency Injection Types
//    1. Constructor-based    - dependencies are set by creating the bean using its constructor
//    2. Setter-based         - dependencies are set by calling setter methods on your beans
//    3. Field: No setter or constructor    - dependency is injected using reflection

//  Example: Let's create YourBusinessClass and inject Dependency1 and Dependency2 into this class

@Component
class YourBusinessClass {
    // FIELD INJECTION

    // Dependency1 dependency1;    // without the @Autowired annotation, this will return NULL
    // Dependency2 dependency2;    // without the @Autowired annotation, this will return NULL
    
    // @Autowired
    Dependency1 dependency1;

    // @Autowired
    Dependency2 dependency2;

    // CONSTRUCTOR INJECTION
    // @Autowired   // this is not mandatory for Constructor Injection
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        // super();
        System.out.println("Constructor Injection - YourBusinessClass");    //  This will appear on the first line of the output
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
        
    }

    // SETTER INJECTION
    // @Autowired
    // public void setDependency1(Dependency1 dependency1) {
    //     System.out.println("Setter Injection - setDependency1");    //  This will appear on the first line of the output
    //     this.dependency1 = dependency1;
    // }
    
    // @Autowired
    // public void setDependency2(Dependency2 dependency2) {
    //     System.out.println("Setter Injection - setDependency2");    //  This will appear on the second line of the output
    //     this.dependency2 = dependency2;
    // }

    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;      
        // String is not really efficient for concatenation
        // Use StringBuffer instead, if you're concatenating a lot of Strings
    }
}

@Component
class Dependency1 { }

@Component
class Dependency2 { }

@Configuration
@ComponentScan  //  package name is not declared bcoz we're scanning the same pkg
public class DepInjectionLauncher {
    public static void main(String[] args) {
        try (
            var context = new AnnotationConfigApplicationContext(DepInjectionLauncher.class)
        ) {
            // System.out.println();
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            // System.out.println("\n" + context.getBean("yourBusinessClass") + "\n");
            // System.out.println("\n" + context.getBean(YourBusinessClass.class).getClass().getSimpleName() + " Dependency Injection Example:\n");
            System.out.println(context.getBean(YourBusinessClass.class) + "\n");
        } catch (Exception e) {
            System.out.println("\n" + e.getClass().getSimpleName() + "\n");
            System.out.println(e.getMessage());
        }
    }
}