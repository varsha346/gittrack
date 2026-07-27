package com.varsha.gittrack.service;

import com.varsha.gittrack.dto.user.UpdateProfileInput;
import com.varsha.gittrack.entity.User;
import com.varsha.gittrack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateProfile(UpdateProfileInput input) {

        User user = getCurrentUser();

        user.setBio(input.getBio());
        user.setAvatarUrl(input.getAvatarUrl());

        return userRepository.save(user);
    }
}