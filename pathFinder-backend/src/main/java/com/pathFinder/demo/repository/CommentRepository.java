package com.pathFinder.demo.repository;

import com.pathFinder.demo.domain.entity.Comment;
import com.pathFinder.demo.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAll();
}
