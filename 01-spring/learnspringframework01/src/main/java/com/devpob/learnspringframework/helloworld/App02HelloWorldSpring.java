package com.devpob.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        // Step 1: Configure the @Configuration class where beans are defined and the objects (a.k.a. Beans) that we want Spring to manage
        // --> HelloWorldConfiguration - @Configuration
        // --> name - @Bean 
        
        // Step 2: Launch a Spring Context
        try(
            var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);  // Try to run the app after adding this line and you shouldn't get an error
            //  Now, we can say that we have successfully launched a Spring Context using a Configuration file (HelloWorldConfiguration.class)
        ) {
            // Step 3: Retrieve Beans managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("person5Qualifier"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean("address3"));

            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean(Address.class));
            /* System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person2WithAddress"));
            System.out.println(context.getBean("person3Parameters"));
            // System.out.println(context.getBean("address"));
            // System.out.println(context.getBean(Address.class));     //  Retrieve bean by type
            System.out.println(context.getBean(Person.class));      //  Cannot be retrieved because Person class is being used more than once // Error: No qualifying bean of type 'com.devpob.learnspringframework.Person' available: expected single matching bean but found 2: person,person2MethodCall
            System.out.println(context.getBean(PersonWithAddress.class));
            System.out.println(context.getBean("person5Qualifier")); */
            
            
            /* // To List all the Spring Beans
            System.out.println("\nList of Spring Beans: ");
            // String[] beansList = context.getBeanDefinitionNames();
            // for (String string : beansList) {
            //     System.out.println(string);
            // }
            
            // OR print each element using functional programming
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println); */
        } catch (Exception e) {
            System.out.println("\n" + e.getClass().getSimpleName() + ":\n");
            System.out.println(e.getMessage() + "\n");
        }
    }
}




package com.devpob.learnspringframework.helloworld;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        // Step 1: Configure the @Configuration class where beans are defined and the objects (a.k.a. Beans) that we want Spring to manage
        // --> HelloWorldConfiguration - @Configuration
        // --> name - @Bean 
        
        // Step 2: Launch a Spring Context
        try(
            var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);  // Try to run the app after adding this line and you shouldn't get an error
            //  Now, we can say that we have successfully launched a Spring Context using a Configuration file (HelloWorldConfiguration.class)
        ) {
            // Step 3: Retrieve Beans managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("person5Qualifier"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean("address3"));

            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean(Address.class));
        } catch (Exception e) {
            System.out.println("\n" + e.getClass().getSimpleName() + ":\n");
            System.out.println(e.getMessage() + "\n");
        }
    }
}