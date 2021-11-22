package org.hillcresthighschool.questions.controller;

import org.hillcresthighschool.questions.dto.QuestionDTO;
import org.hillcresthighschool.questions.service.QuestionService;
import org.hillcresthighschool.user.dto.UserDTO;
import org.hillcresthighschool.user.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/createquestion")
    public String createQuestion(Model model, @ModelAttribute QuestionDTO question) {
        System.out.println("Question: " + question.toString());
        var savedQuestion = questionService.createQuestion(question);
        var result = QuestionDTO.builder()
                .text(savedQuestion.getText())
                .date(savedQuestion.getDate())
                .anonymous(savedQuestion.isAnonymous())
                .approvedBy(savedQuestion.getApprovedBy())
                .id(savedQuestion.getId())
//                .userID(savedQuestion.getUserID())
                .likes(savedQuestion.getLikes())
                .build();
        model.addAttribute("question", result);
        return "question/questionSuccess";
    }


    @GetMapping("/questions")
    public String hello(Model model) {
        model.addAttribute("question", new QuestionDTO());
        return "question/addQuestion";
    }}
