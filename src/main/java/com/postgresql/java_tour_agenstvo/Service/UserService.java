package com.postgresql.java_tour_agenstvo.Service;


import com.postgresql.java_tour_agenstvo.Repository.UserRepository;
import com.postgresql.java_tour_agenstvo.Tour.Role;
import com.postgresql.java_tour_agenstvo.Tour.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }
}
