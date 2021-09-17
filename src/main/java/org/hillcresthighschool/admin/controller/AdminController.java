package org.hillcresthighschool.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AdminController {

    @GetMapping("/admin")
    public String admin() {
        return "Rishab is cool";
    }
}
