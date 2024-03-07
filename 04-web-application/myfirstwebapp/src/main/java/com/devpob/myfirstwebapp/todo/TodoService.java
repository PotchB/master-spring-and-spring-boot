package com.devpob.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todos;

    private static int todosCount = 0;

    static {
        todos = new ArrayList<>();
        todos.add(new Todo(++todosCount, "devpob", "Learn AWS for devpob", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "devpob", "Learn DevOps for devpob", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "devpob", "Learn Full Stack Development for devpob", LocalDate.now().plusYears(3), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn Azure for in28minutes", LocalDate.now().plusYears(3), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn DevOps for in28minutes", LocalDate.now().plusYears(3), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn Full Stack Development for in28minutes", LocalDate.now().plusYears(3), false));
    }

    // Get all todos related to a specific user
    public List<Todo> findByUsername(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }

    public List<Todo> findAllTodos() {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        todos.add(new Todo(++todosCount, username, description, targetDate, done));
    }

    public void deleteTodoById(int id) {
        // Todo todoToBeRemoved = todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
        // todos.remove(todoToBeRemoved);
        todos.removeIf(todo -> todo.getId() == id);
        resetLastId();
    }

    //  To reset the Id numbering
    public void resetLastId() {
        todosCount = todos.stream().mapToInt(Todo::getId).max().orElse(0);
    }

    //  For Updating Todo
    public Todo findById(int id) {
        // return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }
    
    //  For Updating Todo
    public int getIndexFromId(int id) {
        return todos.indexOf(findById(id));
    }
    
    //  For Updating Todo
    // public void updateTodo(int id, Todo todo) {
    //     int index = getIndexFromId(id);
    //     todos.set(index, new Todo(id, todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.getDone()));
    // }

    public void updateTodo(int id, String username, String description, LocalDate targetDate, boolean b) {
        int index = getIndexFromId(id);
        todos.set(index, new Todo(id, username, description, targetDate, b));
    }
}