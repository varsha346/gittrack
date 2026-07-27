package com.varsha.gittrack.dto.repository;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import com.varsha.gittrack.entity.enums.Visibility;


@Data
public class CreateRepositoryInput {

    @NotBlank
    private String name;

    private String description;

    private Visibility visibility;
}