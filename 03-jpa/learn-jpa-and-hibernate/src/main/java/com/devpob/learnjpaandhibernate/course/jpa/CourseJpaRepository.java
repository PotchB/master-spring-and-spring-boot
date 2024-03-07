package com.devpob.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional      //  whenever you'd want to execute queries with JPA, you need to have a Transaction enabled by adding @Transactional
public class CourseJpaRepository {

    // If you'd want to make use of JPA to talk to the database, use EntityManager
    // @Autowired   // Instead of @Autowired, we use a more specific annotation called @PersistenceContext 
    // as it expresses a dependency on a container-managed EntityManager and its associated persistence context.
    @PersistenceContext
    private EntityManager entityManager;    // To manage our entities (classes annotated with @Entity)

    //  INSERT
    public void insert(Course course) {
        // merge method is what's used to insert a row in the database
        entityManager.merge(course);
    }

    //  DELETE BY ID
    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    //  RETRIEVE DATA BY ID
    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }
}