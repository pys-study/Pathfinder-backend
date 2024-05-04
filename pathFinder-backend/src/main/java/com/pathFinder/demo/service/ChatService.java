package com.pathFinder.demo.service;

import com.pathFinder.demo.domain.dto.ChatDto;
import com.pathFinder.demo.domain.entity.Chat;

import java.util.List;

public interface ChatService {

    Chat saveChat(Long userId, Long chattingRoomId, ChatDto chatDto);

    List<Chat> getChat(Long userId, Long chattingRoomId);

}
