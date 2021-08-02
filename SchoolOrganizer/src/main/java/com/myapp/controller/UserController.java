package com.myapp.controller;

import com.myapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.myapp.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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
        modelAndView.setViewName("successfullyRegisteredUser");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginForm");
        modelAndView.addObject("userJSP", new User());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("loginUser", user);
        User dbUser = userService.getUser(user.getEmail());

        if (dbUser != null) {
            if (dbUser.getPassword().equals(user.getPassword())) {
                modelAndView.setViewName("authorization");
                return modelAndView;

            } else {
                modelAndView.setViewName("passwordError");
            }
            return modelAndView;
        }
        modelAndView.setViewName("authorizationError");

        return modelAndView;

    }


}
