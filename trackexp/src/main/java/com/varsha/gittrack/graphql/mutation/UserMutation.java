package com.varsha.gittrack.graphql.mutation;

import com.varsha.gittrack.dto.user.UpdateProfileInput;
import com.varsha.gittrack.entity.User;
import com.varsha.gittrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserMutation {

    private final UserService userService;

    @MutationMapping
    public User updateProfile(@Argument UpdateProfileInput input) {
        return userService.updateProfile(input);
    }
}