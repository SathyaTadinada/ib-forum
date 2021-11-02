package org.hillcresthighschool.questions.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionDTO {
    private Integer id;
    private Integer userID;
    private String text;
    private Long date;
    private boolean anonymous;
    private Integer approvedBy;
    private Integer likes;

}
