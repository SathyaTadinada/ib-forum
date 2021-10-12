package org.hillcresthighschool.user.dto;

import lombok.*;
import org.hillcresthighschool.user.entity.UserType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private String firstName;
    private String lastName;
    private Integer userID;
    private String email;
    private String password;
    private String phoneNumber;
    private String username;
//    private UserType type;

}
