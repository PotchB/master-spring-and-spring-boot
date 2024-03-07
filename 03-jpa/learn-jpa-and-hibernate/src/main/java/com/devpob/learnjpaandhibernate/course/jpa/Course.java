package com.devpob.learnjpaandhibernate.course.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity     // To map this bean to a table with a diff name --> @Entity(name="Course_Details")
public class Course {
    
    @Id     // Primary Key
    private long id;

    // @Column(name="name")     // @Column(name="") is not mandatory since the field and column name is the same 
    private String name;

    // @Column(name="author")   // @Column(name="") is not mandatory since the field and column name is the same
    private String author;

    public Course() { }

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
    }
}