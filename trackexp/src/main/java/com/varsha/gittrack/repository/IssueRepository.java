package com.varsha.gittrack.repository;

import com.varsha.gittrack.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}