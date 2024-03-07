package com.devpob.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")  // Whenever you'd want to retain Model values across certain requests; 'name'- is a model attribute name; Put this in ALL the Controllers where you'd want to make use of the model attributes
public class WelcomeController {

    /* private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    } */

    /*
     * private Logger logger = LoggerFactory.getLogger(getClass());
     * 
     * // http://localhost:8080/login?name=Potch
     * // To pass anything from your controller to JSP, use a concept called Model
     * // Put the param into a model and pass it onto your JSP
     * // Spring MVC provides a Model map
     * 
     * @RequestMapping("/login")
     * public String login(@RequestParam String name, Model model) {
     * model.addAttribute("name", name); // arguments: (attr name: "name", attr
     * value: name)
     * 
     * // logger.trace("I want this at trace level");
     * logger.debug("Request param is {}", name);
     * // logger.info("I want this at info level");
     * // logger.warn("I want this at warn level");
     * // logger.error("I want this at error level");
     * // System.out.println("Request param is " + name); // NOT RECOMMENDED FOR
     * PROD
     * 
     * return "login";
     * }
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        // to put the name of the logged in user, we put the username from the SecurityContextHolder into the model and display it via the Controllers that need it
        model.put("name", getLoggedinUsername());
        return "welcome";
    }
     
    /* @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);
            // model.put("password", password);
            return "welcome";
        }

        model.put("errorMessage", "* Invalid Credentials! Please try again.");
        return "login";
    } */

    private String getLoggedinUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}