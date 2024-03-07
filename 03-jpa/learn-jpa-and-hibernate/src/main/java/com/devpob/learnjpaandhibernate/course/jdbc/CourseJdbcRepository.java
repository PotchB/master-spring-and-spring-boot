package com.devpob.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    // fire queries to the database by importing JdbcTemplate
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    // """ -> enclosed in three double quotes is called TEXT BLOCK
    private static final String INSERT_QUERY = 
    """         
        INSERT INTO course (id, name, author) VALUES
            (?, ?, ?);        
    """;

    private static final String DELETE_BY_ID_QUERY = 
    """         
        DELETE FROM course WHERE id = ?;        
    """;

    private static final String SELECT_BY_ID_QUERY = 
    """         
        SELECT * FROM course WHERE id = ?;        
    """;

    // execute this method at startup using the CommandLineRunner concept
    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_BY_ID_QUERY, id);
    }

    public Course findById(long id) {
        return springJdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
        // ResultSet -> Bean => Row Mapper (maps each row in the ResultSet to a specific bean)
        // id (this is the input)

        // In our situation, our column names in the table match the exact names in the bean (id, name, author)
        // Therefore, we can use something called BeanPropertyRowMapper(Class<T> mappedClass)
        // as a second argument in queryForObject --> new BeanPropertyRowMapper<>(Course.class)
    }
}