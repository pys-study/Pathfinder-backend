package com.pathFinder.demo.repository;

import com.pathFinder.demo.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
