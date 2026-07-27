package com.varsha.gittrack.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Label extends BaseEntity {

    private String name;

    private String color;

    @ManyToOne
    @JoinColumn(name = "repository_id")
    private GitRepository repository;

    @ManyToMany(mappedBy = "labels")
    private List<Issue> issues;
}