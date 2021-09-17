package org.hillcresthighschool.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private String firstName;
    private String lastName;
    private Long userID;
    private String email;
    private String password;
    private String phoneNumber;
    private String username;


}
