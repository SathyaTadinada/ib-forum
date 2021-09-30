package org.hillcresthighschool.user.controller;

import org.hillcresthighschool.user.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {
    @GetMapping("/greeting")
    public String greeting() {
        return "Hello World";
    }
    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO user) {
        System.out.println("User: " + user.toString());
        return user;
    }
}
