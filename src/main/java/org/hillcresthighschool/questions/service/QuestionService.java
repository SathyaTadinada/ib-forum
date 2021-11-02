package org.hillcresthighschool.questions.service;

import org.hillcresthighschool.questions.dto.QuestionDTO;
import org.hillcresthighschool.questions.entity.Question;

public interface QuestionService {
    Question createQuestion(QuestionDTO dto);
}
