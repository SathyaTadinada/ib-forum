package org.hillcresthighschool.responses.entity;

import lombok.*;
import org.hillcresthighschool.user.entity.User;

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

  /*  @Column(name="user_id")
    private Integer userID;*/

    /*@Column(name="question_id")
    private Integer questionID;*/

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userResponse;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private User question;


}
