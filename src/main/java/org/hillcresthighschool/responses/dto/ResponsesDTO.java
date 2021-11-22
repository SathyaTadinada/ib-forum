package org.hillcresthighschool.responses.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponsesDTO {
    private Integer id;
    private Integer userID;
    private Integer question_ID;
    private String text;
    private Long date;
    private boolean anonymous;
    private Integer approvedBy;
    private Integer likes;
}
