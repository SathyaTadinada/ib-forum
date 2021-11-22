package org.hillcresthighschool.questions.entity;

import lombok.*;
import org.hillcresthighschool.category.entity.Category;
import org.hillcresthighschool.user.entity.User;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="question")
public class Question {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column (name="id")
    private Integer id;

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
    private User user; //lazy loading or one column alts
    // holds reference, so won't load if un-needed

    @ManyToMany()
    @JoinTable(name = "question_category",
    joinColumns = {@JoinColumn(name="question_id")},
    inverseJoinColumns = {@JoinColumn(name="category_id")})
    private Set<Category> categories;

    @ManyToMany()
    @JoinTable(name = "question_likes",
            joinColumns = {@JoinColumn(name="question_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id")})
    private Set<User> usersLikes;


}
