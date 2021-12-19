package org.hillcresthighschool.user.entity;

import lombok.*;
import org.hillcresthighschool.category.entity.Category;
import org.hillcresthighschool.questions.entity.Question;
import org.hillcresthighschool.responses.entity.Response;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User implements UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column (name="id")
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

    @OneToMany(mappedBy = "user")
    private List<Question> questions;

    @OneToMany(mappedBy = "userResponse")
    private List<Response> responses;

    @ManyToMany(mappedBy = "usersLikes")
    private Set<Question> questionsLikes;


    @Column(name="user_type")
    private int userType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "read");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    // was the other thing deleted? or did we not have?

}
