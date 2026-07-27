package com.varsha.gittrack.dto.user;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileInput {

    @Size(max = 100)
    private String bio;

    private String avatarUrl;
}