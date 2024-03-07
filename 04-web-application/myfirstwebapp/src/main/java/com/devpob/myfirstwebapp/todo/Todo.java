package com.devpob.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

@Entity     // @Entity(name = "TodoABC") --> this will provide a custom table name for Todo bean
public class Todo {
    // - id
    // - username (owner of todo)
    // - description (of todo)
    // - targetDate (when to do it)
    // - done (status)
    @Id     // Primary Key
    @GeneratedValue
    private int id;
    private String username;
    @Size(min=10, message="* Enter at least 10 characters")
    private String description;
    @FutureOrPresent(message="* Select a present or a future date")
    private LocalDate targetDate;
    private boolean done;

    public Todo() { }

    public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return this.targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return this.done;
    }

    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
                + targetDate + ", done=" + done + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, description, targetDate, done);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Todo))
            return false;
        Todo other = (Todo) obj;
        return id == other.id && Objects.equals(username, other.username)
                && Objects.equals(description, other.description) && Objects.equals(targetDate, other.targetDate)
                && done == other.done;
    }
}