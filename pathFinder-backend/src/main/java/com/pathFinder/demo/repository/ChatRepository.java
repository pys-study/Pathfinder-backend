package com.pathFinder.demo.repository;

import com.pathFinder.demo.domain.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByChattingRoom_ChattingRoomId(Long chattingRoomId);

}
