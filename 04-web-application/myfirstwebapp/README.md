# Todo App
### Requirements of this Project:
- Login page
- Welcome Page → Manage todos
- Your todos
    - Show all todos
    - Add
    - Delete
    - Update


### Create Todo beans

#### Todo Bean Attributes
- id
- username (owner of todo)
- description (of todo)
- targetDate (when to do it)
- done (status)

### What we'll do
1. Create Static List of todos
2. Create Database (H2)
3. Create Database (MySQL)


### Create a Page to list Todos
1. TodoController
2. listTodos.jsp

## Request vs Model vs Session
Whenever you put something in a Model, BY DEFAULT, it’s only available for the scope of that request.

If you’d want to retain values across certain requests, one of the options is to use SESSION.

`@SessionAtrribute("<model_attr_name>")`
Put this on the class/type level of ALL the controllers where you’d want to make use of the Model attribute(s)

#### Session vs Request Scope
- All requests from browser are handled by our web app deployed on a server
- <b>Request Scope:</b> Active for a single request <b>ONLY</b>
    - Once the response is sent back, the request attributes will be removed from memory
    - These cannot be used for future requests
    - Recommended for most use case
    - By default, anything you put into model is also Request Scope
- <b>Session Scope:</b> Details are stored across multiple requests
    - Be careful about what you store in session <i>(Takes additional memory as all details are stored on server)</i>
    - Add @SessionAttributes annotation to make use of Session Scope

## Server-side Validations
Validations you implement in HTML and JavaScript or mainly the client-side can easily be overridden by hackers.

    BEST PRACTICE: 
    ALWAYS have Server-side validations. 
    You’d want to implement validations in your Java code.

Steps:
1. Add a spring-boot-starter-validation dependency after starter-web in pom.xml
        
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

2. Use a concept called ``Command Bean`` or ``Form Backing Object``
    - `2-way binding` (todo.jsp & TodoController.java) (`Bean -> Form` and `Form -> Bean`)
    - use [Spring's form tag library](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/view.html#:~:text=18.2.4%C2%A0Using%20Spring%27s%20form%20tag%20library) for binding
        - todo.jsp
            - `<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>`
            - form:form modelAttribute - maps to the specific Bean in your Controller handler request parameter. 
            <br>Make sure that: `Bean param name = modelAttribute value` <br>(In this case, `'todo'`)
            - form:input path - maps to the specific Bean field. 
            <br>Make sure that: `Bean field name = path value`
            <br>(In this case, `'description'`)
        - TodoController
            - Bean -> Form: Whatever you have in Controller will reflect in your Form
                - Binding: Set an attribute 'todo' into the Model using model.put() in GET request showNewTodoPage(). This will set the default model for your GET request showNewTodoPage(), which will reflect in your form as well -- this step is required. <br>Otherwise: IllegalStateException: Neither BindingResult nor plain target object for bean name 'todo' available as request attribute
            <br>After doing this, make sure to create hidden input tags for other Bean fields ('id' and 'done') in addTodo.jsp. Otherwise: Error: Field error in object 'todo' on field 'id' and 'done': rejected value [null]; codes
            - Form -> Bean: Whatever you submit in your Form, will be bound to the Bean in Controller
                <br>Handle the model in your POST request addNewTodo()
                - Binding: bind your backing object by replacing ```@RequestParam String name``` with ```Todo todo```
                - to redirect to /list-todos endpoint after adding the object via todoService.addTodo() and reflect the changes in the View, return to `redirect:<endpoint>`
3. Add Validations to Bean
    - Todo.java (i.e., description–min # of char is 10, targetDate–always be present date or future date)
    - Add `@Size` above String description field. `@Size(min=10, message="* Enter at least 10 characters")`
    <br>Ctrl+click the @Size and look for the package it belongs to and inside Java Projects > Maven Dependencies, you will find that it belongs to `jakarta.validation.constraints` package inside `jakarta.validation-api:3.0.2.jar`, which was auto-added when we added the `spring-boot-starter-validation` dependency. 
    <br>When you expand the package, you will see other constraints available for use with your validation.
    <br>You can also expand Maven > right click your app name > select Show Dependencies 
    - To trigger validation, add `@Valid` annotation on your Bean parameter in the TodoController method addNewTodo(). `addNewTodo(ModelMap model, @Valid Todo todo)` Package: `jakarta.validation.Valid`
4. Display Validation Errors in the View
    - TodoController.java
        - Add a parameter `BindingResult result` in addNewTodo()
        - Add a logic to return to the same endpoint if ``result.hasErrors()``
    - addTodo.jsp
        - Add `<form:errors path="description" cssClass="text-warning" />` under the element you would like to display the error. Important attribute: `path` 
        <br>Make sure that: `form:errors path value = form:input path value` you're making validations on.
        <br>Do not forget the closing slash.
        - When making use of Spring tags, use `cssClass` instead of class to customize styling with bootstrap.


## Calendar Date Picker

### pom.xml
```xml
    <!-- https://mvnrepository.com/artifact/org.webjars/bootstrap-datepicker -->
    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>bootstrap-datepicker</artifactId>
        <version>1.10.0</version>
    </dependency>
```
Remember: In the case of Static Content, all versions are not managed by Spring Boot Starter Parent, so we need to explicitly specify them.

### JSP Snippets
```jsp
    <link href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
    
    <fieldset class="mb-3">				
        <form:label path="description">Description</form:label>
        <form:input type="text" path="description" required="required"/>
        <form:errors path="description" cssClass="text-warning"/>
    </fieldset>
    <fieldset class="mb-3">				
        <form:label path="targetDate">Target Date</form:label>
        <form:input type="text" path="targetDate" required="required"/>
        <form:errors path="targetDate" cssClass="text-warning"/>
    </fieldset>
            
    <script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
        $('#targetDate').datepicker({
            format: 'yyyy-mm-dd'
        });
    </script>
```


## JSP

Typically, all JSPs should be created here:
>       /src/main/resource/META-INF/resources/WEB-INF/jsp

#### View Resolver Configuration ( application.properties )
- For JSP, whenever you get a request for the View, use this as the prefix and suffix to the String that's being returned by the controller method/request handler
- /src/main/resources/META-INF/resources/WEB-INF/jsp/    --> do not forget the trailing slash, otherwise, it won't work
- Spring MVC already knows the /src/main/resources/META-INF/resources, so you can start with WEB-INF

```
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

## JSP Standard Tag Library (JSTL)
### pom.xml
```xml
<!--  #####  JSTL Dependencies  #####  -->

<!-- JSTL API -->
<!-- https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api -->
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
</dependency>

<!-- JSTL Implementation -->
<!-- https://mvnrepository.com/artifact/org.eclipse.jetty/glassfish-jstl -->
<dependency>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>glassfish-jstl</artifactId>
    <version>11.0.19</version>
</dependency>
```
### in JSP
Put this on the 1st line
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```
To Configure a Form Backing Object to bind an object from a Controller
```jsp
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
```

## JSP Fragments
resources/META-INF/resources/WEB-INF/resources/common/
- footer.jspf
- header.jspf
- navigation.jspf

paste the navbar snippet inside the navigation.jspf
<br>In listTodos.jsp, add this snippet to point to the common navbar
<br>
```jsp
<%@ include file="common/navigation.jspf" %>
```



## Navbar
Github link to Navigation content: [11-web-application](https://github.com/in28minutes/master-spring-and-spring-boot/tree/main/11-web-application#navigation---html--bootstrap) 

#### Snippet
```html
<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
    <a class="navbar-brand m-1" href="https://courses.in28minutes.com">in28Minutes</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
        </ul>
    </div>
    <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
    </ul>	
</nav>
```




## Spring Security
In preparation, create a `WelcomeController.java` that will have one endpoint: /
<br>Returning the `welcome.jsp` View
<br>Hardcode the name for now in the model(ModelMap) → `model.put("name", "devpob")`, will fix later
<br>Annotate it with `@Controller` and `@SessionAttributes("name")`
<hr>

### Configure Spring Security
Steps:

1. In pom.xml, add dependency under spring-boot-starter-web
```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
    <version>3.2.1</version>
</dependency>
```

2. Re-run the app and you will be taken to a /login endpoint generated by Spring Security

3. The log will show the `generated security password` used for development only
    <br><br>To log in, use these credentials
    - Username: `user`
    - Password: *`<Spring Security generated security password>`*


### Set up users and passwords with Spring Security
1. Go to root package and create `security` folder
2. Create `security/SpringSecurityConfiguration.java`
3. Typically, whenever you'd want to store usernames and passwords, you'd make use of `LDAP` or atleast a `Database`
   <br>To keep things simple, we'll make use of an InMemory configurator
4. In `SpringSecurityConfiguration.java`
    use `InMemoryUserDetailsManager` that has a constructor: <br>`public InMemoryUserDetailsManager(Collection<UserDetails> users) { }`
    - Create UserDetails object by making use of User builder
    - Build an InMemoryUserDetailsManager class
    - Return it back
    <br>*Note* UserDetails is an interface and we cannot directly create an instance of it. So we'll use a builder 
5. Refactor your code to easily add more users
    shortcut to refactor -> Ctrl+Shift+R
6. Create an AppUser class to hold the username, password, and Role (create an Enum Role)
7. Run the app and test the login from different browsers (Chrome and Safari)
8. If the user made changes to his todos, it should still appear once they re-login. In this case, make sure the "todos" is added in @SessionAttributes in your TodoController
```java
@SessionAttributes(names = {"name", "todos"})
```

### Avoid Hard-coding the Logged in User
#### SecurityContextHolder
To display the name of the user that's logged in, we use Spring Security's SecurityContextHolder
```java
private String getLoggedinUsername() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authentication.getName();
}
```
Then call this method when putting it as a name in the model
```java
model.put("name", getLoggedinUsername());
```
Then make sure that this annotation is above your Controller class
```java
@SessionAttributes("name")
```
This will enable logged in name detection throughout the session

### Add Spring Boot Starter JPA and Get H2 Database Ready!
H2 console will not be accessible even after you've configured everything in pom.xml and application.properties
and even after you log in through the Spring Security Login Page
```
    H2 CONSOLE WILL NOT WORK BECAUSE OF SPRING SECURITY CONFIGURATION -- ERROR: 403 Forbidden
```

### Configure Spring Security to Get H2 Console Working
All endpoints available in your app, when visited, will be redirected to Spring Security login page since you have configured Spring Security

    By Default, with Spring Security,
        - All URLs are PROTECTED
        - A login form is shown for unauthorized requests
        - CSRF is enabled
        - Frames are NOT allowed.   H2 uses Frames.  ->In HTML, you can use frames

```
Solutions to Configure:
    - DISABLE CSRF (Cross-Site Request Forgery)
    - ALLOW FRAMES
``` 
```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
    http.formLogin(withDefaults());

    http.csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")));
    http.headers(headers -> headers.frameOptions(withDefaults()).disable());
    
    return http.build();
}
```
### Configure Entity for JPA with H2
In Todo.java, apply these annotations
```java
@Entity			    // maps the Bean to Table – will be auto created in H2 database
@Id				    // primary key
@GeneratedValue		// for auto_increment
```
### Populate Data to Start Off
1. Create a file called data.sql in src/main/resources package
2. Do an INSERT
    ```sql
    INSERT INTO todo (ID, NAME, DESCRIPTION, TARGET_DATE, DONE) VALUES 
    (10001, 'devpob', 'Learn AWS for devpob', CURRENT_DATE(), false);

    ```
    Because of @GeneratedValue, the counting starts at 1, so we'll insert 10001 here

By default, data.sql is executed before the entities are processed
This will return a Table NOT FOUND error

Solution:  <br>
application.properties <br>
`spring.jpa.defer-datasource-initialization=true`

### JpaRepository
Create TodoRepository.java interface and extend JpaRepository
Define a custom abstract method following the  
```
Custom CRUD naming convention:
    <action><field_value>(<parameter_that_matches_field_value>)
```
Ex. List<Todo> findByUsername(String username);

Create a TodoControllerJpa.java to understand the operations provided by JpaRepository and replace the operations performed by TodoService

To understand what’s happening in the background with all these operations, you can add this setting in application.properties
```
	spring.jpa.show-sql=true
```

### Summary of adding Spring Data JPA and H2
When we added Data JPA and H2 dependencies, Spring Boot AutoConfig magic does these:
- Initialize JPA and Spring Data JPA frameworks
- Launch an in memory database (H2)
- Setup connection from App to in-memory database
- Launch a few scripts at startup (e.g., data.sql)
