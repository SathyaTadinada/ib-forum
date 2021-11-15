package org.hillcresthighschool.user.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column (name="users_id")
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phoneNumber;

    @Column(name="username")
    private String username;

    @Column(name="password_hash")
    private String password;

    @Column(name="salt")
    private String salt;

}
