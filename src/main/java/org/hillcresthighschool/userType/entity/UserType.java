package org.hillcresthighschool.userType.entity;

import lombok.*;
import org.hillcresthighschool.questions.entity.Question;
import org.hillcresthighschool.user.entity.User;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="response")
public class UserType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column (name="id")
    private Integer id;

  /*  @Column(name="user_id")
    private Integer userID;*/

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "userType")
    private List<User> users;



}
