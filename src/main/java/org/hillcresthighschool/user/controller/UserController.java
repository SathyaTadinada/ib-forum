package org.hillcresthighschool.user.controller;

import org.hillcresthighschool.user.dto.UserDTO;
import org.hillcresthighschool.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO user) {
        System.out.println("User: " + user.toString());
        var savedUser = userService.createUser(user);
        return UserDTO.builder()
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .phoneNumber(savedUser.getPhoneNumber())
                .username(savedUser.getUsername())
                .userID(savedUser.getId())
                .build();
    }
    @GetMapping ("/hello")
    public String hello(Model model) {
        return "createAccount";
    }
}
