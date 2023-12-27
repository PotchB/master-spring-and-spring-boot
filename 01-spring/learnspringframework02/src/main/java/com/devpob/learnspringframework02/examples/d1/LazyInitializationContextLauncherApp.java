package com.devpob.learnspringframework02.examples.d1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/* 
 * NOTE:                  Eager - default Spring Bean initialization
 *          Lazy initialization - Spring Bean will only be initialized when it's requested for the first time
 * 
 *          use @Lazy for Lazy Initialization
 */

@Component
class ClassA { }

@Component
@Lazy
class ClassB {
    private ClassA classA;
    public ClassB(ClassA classA) {
        System.out.println("ClassB initialization logic");
        this.classA = classA; 
    }

    public void doSomething() {
        System.out.println("Doing something");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationContextLauncherApp {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitializationContextLauncherApp.class)) {
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("Initialization of context is completed");
            ClassB classB = context.getBean(ClassB.class);  //  since this is only when we're calling ClassB and it's annotated with @Lazy, this is only the time the bean will be created
            // classB.doSomething();
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }
}