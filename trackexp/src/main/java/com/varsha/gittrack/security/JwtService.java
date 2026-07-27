package com.varsha.gittrack.security;

import com.varsha.gittrack.entity.User;

public interface JwtService {

    String generateToken(User user);

    String extractUsername(String token);

    boolean isTokenValid(String token, User user);
}