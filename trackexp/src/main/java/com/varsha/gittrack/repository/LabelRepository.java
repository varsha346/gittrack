package com.varsha.gittrack.repository;

import com.varsha.gittrack.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Long> {
}