package org.hillcresthighschool.responses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ResponseController {
    @GetMapping("/responses")
    public String response() {
        return "Hello World";
    }
}
