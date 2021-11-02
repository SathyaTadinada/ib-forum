package org.hillcresthighschool.questions.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class Question {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column (name="id")
    private Integer id;

    @Column(name="user_id")
    private Integer userID;

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
