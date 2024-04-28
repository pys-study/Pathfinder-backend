package com.pathFinder.demo.repository;

import com.pathFinder.demo.domain.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {
}
