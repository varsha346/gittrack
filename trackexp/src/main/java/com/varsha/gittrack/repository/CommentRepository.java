package com.varsha.gittrack.repository;

import com.varsha.gittrack.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}