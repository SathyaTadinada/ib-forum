package org.hillcresthighschool.user.controller;

import org.hillcresthighschool.user.dto.UserDTO;
import org.hillcresthighschool.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createuser")
    public String createUser(Model model, @ModelAttribute UserDTO user) {
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
        model.addAttribute("user", result);
        return "users/userSuccess";
    }

    @GetMapping ("/create")
    public String hello(Model model) {
        model.addAttribute("user", new UserDTO());
        return "users/addUser";
    }


    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpSession session){
        return "users/signin";
    }

}
