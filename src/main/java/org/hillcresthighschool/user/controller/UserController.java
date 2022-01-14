package org.hillcresthighschool.user.controller;

import org.hillcresthighschool.user.dto.UserDTO;
import org.hillcresthighschool.user.entity.User;
import org.hillcresthighschool.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ModelAndView createUser(@ModelAttribute UserDTO user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("User: " + user.toString());
        var savedUser = userService.createUser(user);
        var result = UserDTO.builder()
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .phoneNumber(savedUser.getPhoneNumber())
                .username(savedUser.getUsername())
                .userID(savedUser.getId())
                .build();
        modelAndView.addObject("user", result);
        modelAndView.setViewName("users/userSuccess");
        return modelAndView;
    }

    @GetMapping ("/registration")
    public ModelAndView hello(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        model.addAttribute("user", user);
        modelAndView.setViewName("users/addUser");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/signin");
        return modelAndView;
    }

    @GetMapping("/login-success")
    public ModelAndView loginSuccess() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/loginSuccess");
        return modelAndView;
    }
}
