package org.hillcresthighschool.responses.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="response")
public class Response {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column (name="id")
    private Integer id;

    @Column(name="user_id")
    private Integer userID;

    @Column(name="question_id")
    private Integer questionID;

    @Column(name="text")
    private String text;

    @Column(name="date")
    private Long date;

    @Column(name="anonymous")
    private boolean anonymous;

    @Column(name="approved_by")
    private Integer approvedBy;

    @Column(name="likes")
    private Integer likes;


}
