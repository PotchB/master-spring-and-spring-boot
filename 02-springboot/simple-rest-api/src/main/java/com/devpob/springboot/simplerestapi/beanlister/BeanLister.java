package com.devpob.springboot.simplerestapi.beanlister;

import java.util.Arrays;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * To list all the beans in the Application Context
 */
// @Component
public class BeanLister /* implements CommandLineRunner  */{
    private final ListableBeanFactory beanFactory;

    public BeanLister(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    
    /* @Override
    public void run(String... args) throws Exception {
        String[] allBeanNames = beanFactory.getBeanDefinitionNames();
        Arrays.sort(allBeanNames);
        System.out.println("\n\nList of all beans in the application context");
        for (String bean : allBeanNames) {
            System.out.println(bean);
        }       
    } */
}


// *** TO SEE ALL BEANS, YOU CAN MAKE USE OF SPRING BOOT ACTUATOR INSTEAD. SEE ACTUATOR LECTURE