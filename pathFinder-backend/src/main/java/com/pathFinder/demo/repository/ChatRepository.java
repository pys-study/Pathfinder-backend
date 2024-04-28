package com.pathFinder.demo.repository;

import com.pathFinder.demo.domain.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
