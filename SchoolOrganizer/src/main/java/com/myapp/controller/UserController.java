package com.myapp.controller;

import com.myapp.model.User;
import com.myapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.myapp.service.UserService;


@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public UserController(UserService userService, RoleService roleService) {

        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("homePage");
        modelAndView.addObject("userJSP", new User());
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrationForm");
        modelAndView.addObject("userJSP", new User());
        return modelAndView;
    }


    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", user);

        User dbUser = userService.getUser(user.getEmail());

        if (dbUser != null) {
            modelAndView.setViewName("index");
            return modelAndView;
        }
        userService.createUser(user);
        Long user_id = userService.getUser(user.getEmail()).getId();
        roleService.setUpDefaultUserRole(user_id);

        modelAndView.setViewName("successfullyRegisteredUser");
        return modelAndView;
    }

    @GetMapping("/enter")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Invalid username or password!");
        } else {
            modelAndView.addObject("userJSP", new User());
        }

        modelAndView.setViewName("loginForm");
        return modelAndView;
    }

    @GetMapping("/logoutSuccessful")
    public ModelAndView logout() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logout");
        return modelAndView;
    }


    @GetMapping("/admin")
    public ModelAndView welcomeAdmin() {
        return new ModelAndView("welcomeAdmin");
    }

    @GetMapping("/user")
    public ModelAndView welcomeUser() {
        return new ModelAndView("welcomeUser");
    }


}
