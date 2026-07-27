package com.varsha.gittrack.entity;

import com.varsha.gittrack.entity.enums.Visibility;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class GitRepository extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "repository")
    private List<Issue> issues;

    @OneToMany(mappedBy = "repository")
    private List<Label> labels;

    @OneToMany(mappedBy = "repository")
    private List<Star> stars;
}