package com.devpob.learnspringframework.helloworld;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record is a new feature which was introduced in jdk 16
// eliminates verbosity in creating Java Beans
// public accessor methods, constructor
// equals, hashCode, and toString are auto created
record Person(String name, int age, Address address) {};
record PersonWithAddress(String name, int age, Address address) {};
record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
    
    @Bean   // Indicates that a method produces a bean to be managed by the Spring container.
    public String name() {
        return "Potch";
    }

    @Bean
    public int age() {
        return 36;
    }

    @Bean
    public Person person() {
        return new Person("Test Person 1", 20, address());
    }

    @Bean
    @Primary
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }
    
    @Bean       
    public Person person3Parameters(String name, int age, Address address3) { //  the parameters should match the bean name
        return new Person(name, age, address3);
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
        return new Person(name, age, address);
    }

    @Bean(name = "address2")
    public Address address() {
        return new Address("Baker Street", "London");
    }
    
    @Bean(name = "address3")
    @Primary 
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("Motinagar", "Hyderabad");
    }



    /* 
    //  relationship with existing beans approaches
    //  Approach 1: through method call
    @Bean
    public Person person2MethodCall() {     
        return new Person(name(), age());
    }
    
    @Bean
    @Primary
    public PersonWithAddress person2WithAddress() {
        return new PersonWithAddress(name(), age(), address());   
    }
    
    //  Approach 2: through parameters
    @Bean
    public PersonWithAddress person3Parameters(String name, int age, Address address) {  //  on this part existing beans are being injected or autowired    
        return new PersonWithAddress(name, age, address);
    }

    @Bean(name = "address3")
    @Qualifier("addressQualifier")
    public Address address3() {
        return new Address("Sumulong Hi-way", "Antipolo");
    }

    @Bean
    public PersonWithAddress person5Qualifier(String name, int age, @Qualifier("addressQualifier") Address address) {  //  on this part existing beans are being injected or autowired    
        return new PersonWithAddress(name, age, address);
    } */
}