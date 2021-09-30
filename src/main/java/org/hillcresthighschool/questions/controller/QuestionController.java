package org.hillcresthighschool.questions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class QuestionController {
    @GetMapping("/questions")
    public String questions() {
        return "Hello World";
    }
}
