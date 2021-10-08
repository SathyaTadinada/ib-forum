package org.hillcresthighschool.user.service;

import org.hillcresthighschool.user.dto.UserDTO;
import org.hillcresthighschool.user.entity.User;

public interface UserService {
    User createUser(UserDTO dto);
}
