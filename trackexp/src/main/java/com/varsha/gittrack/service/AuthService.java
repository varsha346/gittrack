package com.varsha.gittrack.service;

import com.varsha.gittrack.dto.auth.AuthResponse;
import com.varsha.gittrack.dto.auth.LoginInput;
import com.varsha.gittrack.dto.auth.RegisterInput;
import com.varsha.gittrack.entity.User;
import com.varsha.gittrack.repository.UserRepository;
import com.varsha.gittrack.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public User register(RegisterInput input) {

        if (userRepository.existsByEmail(input.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (userRepository.existsByUsername(input.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();

        user.setUsername(input.getUsername());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public AuthResponse login(LoginInput input) {

        User user = userRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(input.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }

//    public User getCurrentUser() {
//
//        Authentication authentication =
//                SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || authentication.getPrincipal() == null) {
//            throw new RuntimeException("User not authenticated");
//        }
//
//        return (User) authentication.getPrincipal();
//    }
}