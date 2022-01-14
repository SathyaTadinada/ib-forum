package org.hillcresthighschool.user.service;

import org.hillcresthighschool.user.dto.UserDTO;
import org.hillcresthighschool.user.entity.User;
import org.hillcresthighschool.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, @Qualifier("passwordEncoder") PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User createUser(UserDTO dto) {
        var user = User.builder()
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }
}
