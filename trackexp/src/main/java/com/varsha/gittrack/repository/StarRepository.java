package com.varsha.gittrack.repository;

import com.varsha.gittrack.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Long> {
}