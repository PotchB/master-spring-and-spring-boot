package com.devpob.springboot.simplerestapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devpob.springboot.simplerestapi.model.Course;

@RestController
public class CourseController {
    /**
     * API endpoint: /courses
     * @return Courses: id, name, author
     * 
     */ 
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
            new Course(1, "Learn AWS", "in28Minutes"),
            new Course(2, "Learn DevOps", "in28Minutes")
        );
    }
}