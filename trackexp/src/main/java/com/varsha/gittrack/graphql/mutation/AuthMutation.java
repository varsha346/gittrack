package com.varsha.gittrack.graphql.mutation;

import com.varsha.gittrack.dto.auth.AuthResponse;
import com.varsha.gittrack.dto.auth.LoginInput;
import com.varsha.gittrack.dto.auth.RegisterInput;
import com.varsha.gittrack.entity.User;
import com.varsha.gittrack.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthMutation {

    private final AuthService authService;

    @MutationMapping
    public User register(@Argument RegisterInput input) {
        return authService.register(input);
    }

    @MutationMapping
    public AuthResponse login(@Argument LoginInput input) {
        return authService.login(input);
    }
}