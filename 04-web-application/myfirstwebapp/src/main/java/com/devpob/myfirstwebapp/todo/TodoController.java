package com.devpob.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

// @Controller
@SessionAttributes(names = {"name", "todos"})
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    private String getLoggedinUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    } 

    // endpoint: /list-todos
    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        model.put("name", getLoggedinUsername());
        String username = getUsername(model);  // instead of hardcoding the logged in user, use the name from the model
        List<Todo> todos = todoService.findByUsername(username);
        model.addAttribute("todos", todos);

        return "listTodos";
    }

    // endpoint: /add-todo
    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = getUsername(model);
        // this is where we set default values for our Todo object so that we can add it into the Model
        Todo todo = new Todo(0, username, "", LocalDate.now(), false); // whatever you set in here, you will see it the form
        // whatever values we're setting in here will be bound to whatever is present in the jsp modelAttribute value if we put this todo bean into the Model
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) { // in Spring, to bind a backing object, we define it as a parameter here (Todo todo)
    // @Valid will ensure that the bean is validated before the binding happens.
    // BindingResult is for displaying errors to the user as a result of the validation
    // Validations are implemented in your POJO class (the object that you are validating)
        if(result.hasErrors()) {
            return "todo";
        }

        String username = getUsername(model);
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodoById(id);
        return "redirect:/list-todos";
    }

    // Bean -> Form
    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
        model.put("todo", todoService.findById(id));
        return "todo";
    }

    // Form -> Bean
    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(@RequestParam int id, ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        String username = getUsername(model);
        todoService.updateTodo(id, username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }

    private String getUsername(ModelMap model) {
        String username = (String) model.get("name");
        return username;
    }
}