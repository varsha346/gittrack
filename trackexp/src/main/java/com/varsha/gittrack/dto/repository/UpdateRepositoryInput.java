package com.varsha.gittrack.dto.repository;

import com.varsha.gittrack.entity.enums.Visibility;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateRepositoryInput {

    @NotNull
    private Long id;

    private String description;

    private Visibility visibility;
}