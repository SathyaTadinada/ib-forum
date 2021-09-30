package org.hillcresthighschool.user.service;

import org.hillcresthighschool.user.dto.UserDTO;
import org.hillcresthighschool.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {



    public User createUser(UserDTO dto) {
        var user = new User.UserBuilder().build();
        return null;
    }
}
