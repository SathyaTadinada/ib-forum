package org.hillcresthighschool.responses.controller;

import org.hillcresthighschool.questions.dto.QuestionDTO;
import org.hillcresthighschool.responses.dto.ResponsesDTO;
import org.hillcresthighschool.responses.service.ResponseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ResponseController {
    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping("/createresponse")
    public String createResponse(Model model, @ModelAttribute ResponsesDTO response) {
        System.out.println("Response: " + response.toString());
        var savedResponse = responseService.createResponse(response);
        var result = ResponsesDTO.builder()
                .text(savedResponse.getText())
                .date(savedResponse.getDate())
                .anonymous(savedResponse.isAnonymous())
                .approvedBy(savedResponse.getApprovedBy())
                .id(savedResponse.getId())
                .question_ID(savedResponse.getQuestionID())
                .userID(savedResponse.getUserID())
                .likes(savedResponse.getLikes())
                .build();
        model.addAttribute("response", result);
        return "response/responseSuccess";
    }

    @GetMapping("/responses")
    public String response(Model model) {
        model.addAttribute("response", new ResponsesDTO());
        return "response/addResponse";
    }
}
