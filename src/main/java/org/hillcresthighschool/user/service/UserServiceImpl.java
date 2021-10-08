package org.hillcresthighschool.user.service;

import org.hillcresthighschool.user.dto.UserDTO;
import org.hillcresthighschool.user.entity.User;
import org.hillcresthighschool.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserDTO dto) {
        var user = User.builder()
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .password(dto.getPassword())
                .phoneNumber(dto.getPhoneNumber())
                .username(dto.getUsername())
                .salt(generateRandomHash())
                .build();

        var savedUser = userRepository.save(user);
        return savedUser;
    }

    private String generateRandomHash() {
        var guid = UUID.randomUUID();
        return guid.toString().replaceAll("-", "");
    }
}