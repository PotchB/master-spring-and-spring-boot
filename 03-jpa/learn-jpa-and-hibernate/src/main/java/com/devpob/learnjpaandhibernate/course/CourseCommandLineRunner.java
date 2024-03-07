package com.devpob.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// import com.devpob.learnjpaandhibernate.course.jdbc.Course;
// import com.devpob.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.devpob.learnjpaandhibernate.course.jpa.Course;
import com.devpob.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.devpob.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJdbcRepository repository;

    // @Autowired
    // private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // For JDBC, Spring JDBC, and JPA lectures
        // repository.insert(new Course(1, "Learn Data JPA", "devpob"));
        // repository.insert(new Course(2, "Learn Data JPA", "devpob"));
        // repository.insert(new Course(3, "Learn Data JPA", "devpob"));
        // repository.deleteById(1);
        
        // System.out.println("\n\n" + repository.findById(2));
        // System.out.println(repository.findById(3) + "\n\n\n");

        // For Spring Data JPA lecture
        repository.save(new Course(1, "Learn AWS JPA", "devpob"));
        repository.save(new Course(2, "Learn Azure JPA", "devpob"));
        repository.save(new Course(3, "Learn DevOps JPA", "devpob"));
        repository.deleteById(1L);
        
        System.out.println("\n\n" + repository.findById(2L));
        System.out.println(repository.findById(3L) + "\n\n\n");
        
        System.out.println("findAll() result:\n");
        System.out.println(repository.findAll());
        repository.findAll().forEach(System.out::println);
        System.out.println(repository.count());
        System.out.println();

        // Custom Methods in Repository
        System.out.println(repository.findByAuthor("devpob"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn AWS JPA"));
        System.out.println(repository.findByName("Learn DevOps JPA"));
        System.out.println(repository.findByName(""));
    }
}