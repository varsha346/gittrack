package com.varsha.gittrack.repository;

import com.varsha.gittrack.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}