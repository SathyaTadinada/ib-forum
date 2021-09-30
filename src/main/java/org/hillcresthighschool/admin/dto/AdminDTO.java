package org.hillcresthighschool.admin.dto;

import lombok.*;
import org.hillcresthighschool.user.entity.UserType;

@Getter
@Setter
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class AdminDTO {
    private UserType type;
    private Long userID;
}
