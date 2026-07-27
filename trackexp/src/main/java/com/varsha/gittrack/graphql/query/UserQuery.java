package com.varsha.gittrack.graphql.query;

import com.varsha.gittrack.entity.User;
import com.varsha.gittrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserQuery {

    private final UserService userService;

    @QueryMapping
    public User me() {
        return userService.getCurrentUser();
    }

    @QueryMapping
    public User user(@Argument Long id) {
        return userService.getUserById(id);
    }

    @QueryMapping
    public User userByUsername(@Argument String username) {
        return userService.getUserByUsername(username);
    }
}