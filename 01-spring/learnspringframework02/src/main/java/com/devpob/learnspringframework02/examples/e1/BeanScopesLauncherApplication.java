package com.devpob.learnspringframework02.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/* 
 * BEAN SCOPES - are used to define the lifecycle of a bean
 * @Scope annotation is used
 * 
 * NormalClass represents the Singleton Bean Scope because a normal class has a Singleton bean scope by default
 * Prototype represents the Prototype Bean Scope
 */

@Component
class NormalClass { }

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass { }

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {

            System.out.println(context.getBean(NormalClass.class));     // com.devpob.learnspringframework02.examples.e1.NormalClass@4d02f94e
            System.out.println(context.getBean(NormalClass.class));     // com.devpob.learnspringframework02.examples.e1.NormalClass@4d02f94e
            System.out.println(context.getBean(NormalClass.class));     // com.devpob.learnspringframework02.examples.e1.NormalClass@4d02f94e
            
            System.out.println(context.getBean(PrototypeClass.class));  // com.devpob.learnspringframework02.examples.e1.PrototypeClass@2b48a640
            System.out.println(context.getBean(PrototypeClass.class));  // com.devpob.learnspringframework02.examples.e1.PrototypeClass@1e683a3e
            System.out.println(context.getBean(PrototypeClass.class));  // com.devpob.learnspringframework02.examples.e1.PrototypeClass@2053d869
            System.out.println(context.getBean(PrototypeClass.class));  // com.devpob.learnspringframework02.examples.e1.PrototypeClass@7a419da4

        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
