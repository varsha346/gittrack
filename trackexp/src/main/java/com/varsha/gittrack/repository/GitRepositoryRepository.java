package com.varsha.gittrack.repository;

import com.varsha.gittrack.entity.GitRepository;
import com.varsha.gittrack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GitRepositoryRepository extends JpaRepository<GitRepository, Long> {

    Optional<GitRepository> findByNameAndOwner(String name, User owner);

    List<GitRepository> findByOwner(User owner);
}