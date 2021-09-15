package org.hillcresthighschool.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AdminController {
    @GetMapping("/admin")
    public String admin() {
        return "Hello World";
    }
}
