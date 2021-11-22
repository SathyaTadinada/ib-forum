package org.hillcresthighschool.questions.service;

import org.hillcresthighschool.questions.dto.QuestionDTO;
import org.hillcresthighschool.questions.entity.Question;
import org.hillcresthighschool.questions.repository.QuestionRepository;
import org.hillcresthighschool.user.dto.UserDTO;
import org.hillcresthighschool.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService{
    
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl (QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question createQuestion(QuestionDTO dto) {
        /*User user = User.builder()
                .email("email")
                .firstName("a")
                .lastName("b")
                .phoneNumber("1")
                .username("userName")
                .userID(1).build();*/

        var question = Question.builder()
                .text(dto.getText())
                .date(dto.getDate())
                .anonymous(dto.isAnonymous())
                .approvedBy(dto.getApprovedBy())
/*
                .user(user)
*/
                .build();

        return questionRepository.save(question);
    }



}
