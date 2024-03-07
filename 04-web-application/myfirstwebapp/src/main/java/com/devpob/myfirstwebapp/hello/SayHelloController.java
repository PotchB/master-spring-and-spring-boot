package com.devpob.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    
    //  ----------  RETURNING A STRING  ----------  //
    // "say-hello"  =>  "Hello! What are you learning today?"
    @RequestMapping("/say-hello")
    @ResponseBody       // serializes an object into JSON and will return a String as is
    public String sayHello() {
        return "Hello! What are you learning today?";   
        //  when returning a String, Spring MVC, by default, looks for a view with that specific name
        //  if you want to actually display the String, you need to add @ResponseBody annotation aside from @RequestMapping annotation
    }

    //  ----------  RETURNING A HARD-CODED HTML  ----------  //
    @RequestMapping("/say-hello-html")
    @ResponseBody       // serializes an object into JSON and will return a String as is
    public String sayHelloHTML() {
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE html>");
        sb.append("<html lang=\"en\">");
        sb.append("<head>");
        sb.append("<meta charset=\"UTF-8\">");
        sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        sb.append("<title>My first HTML Page</title>");
        sb.append("</head>");
        sb.append("<body style='background-color: #aaa'>");
        sb.append("<h1>My first html page with body</h1>");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    //  ----------  RETURNING AN HTML VIEW  ----------  //
    //  View technology: JSP
    //  Add dependency for JSP in pom.xml: tomcat-embed-jasper (scope: provided)--> since this has already been provided by Tomcat and Tomcat is embedded in spring-boot-starter-web
    //  Whenever you make changes to pom.xml, RESTART the app!
    //  JSPs are created in /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    //                      /src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
    //                      /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    //                      /src/main/resources/META-INF/resources/WEB-INF/jsp/todos.jsp
    //  in application.properties, declare a constant path to JSPs (View Resolver Configuration) by defining spring.mvc.view.prefix and spring.mvc.view.suffix
    @RequestMapping("/say-hello-jsp")
    // @ResponseBody       // serializes an object into JSON and will return a String as is
    public String sayHelloJSP() {
        return "sayHello";      // Spring MVC makes use of View Resolver to map this to the .jsp file named sayHello
    }   
}