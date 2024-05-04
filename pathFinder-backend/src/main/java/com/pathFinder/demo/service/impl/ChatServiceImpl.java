package com.pathFinder.demo.service.impl;

import com.pathFinder.demo.domain.dto.ChatDto;
import com.pathFinder.demo.domain.entity.Chat;
import com.pathFinder.demo.domain.entity.ChattingRoom;
import com.pathFinder.demo.domain.entity.User;
import com.pathFinder.demo.repository.ChatRepository;
import com.pathFinder.demo.repository.ChattingRoomRepository;
import com.pathFinder.demo.repository.UserRepository;
import com.pathFinder.demo.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final ChattingRoomRepository chattingRoomRepository;

    @Override
    public Chat saveChat(Long userId, Long chattingRoomId, ChatDto chatDto) {

        // 채팅방 정보가 없으면 null 반환
        if (chattingRoomRepository.findById(chattingRoomId).isEmpty())
            return null;

        // 회원 정보가 없으면 null 반환
        if (userRepository.findById(userId).isEmpty())
            return null;


        ChattingRoom chattingRoom = chattingRoomRepository.findById(chattingRoomId).get();
        User user = userRepository.findById(userId).get();

        // 자신의 채팅방이 아님과 동시에 챗봇이 아닌 유저가 보낸 채팅이면 null 반환
        if(chattingRoom.getUser() != user && chatDto.isUserChat())
            return null;

        Chat savedChat = chatDto.toEntity(user, chattingRoom);
        chatRepository.save(savedChat);

        log.info(savedChat.toString());
        return savedChat; // 저장된 Chat 반환
    }

    @Override
    public List<Chat> getChat(Long userId, Long chattingRoomId) {

        // 채팅방 정보가 없으면 null 반환
        if (chattingRoomRepository.findById(chattingRoomId).isEmpty())
            return null;

        // 회원 정보가 없으면 null 반환
        if (userRepository.findById(userId).isEmpty())
            return null;

        ChattingRoom chattingRoom = chattingRoomRepository.findById(chattingRoomId).get();
        User user = userRepository.findById(userId).get();

        // 자신의 채팅방이 아니면 null 반환
        if(chattingRoom.getUser() != user)
            return null;

        return chatRepository.findByChattingRoom_ChattingRoomId(chattingRoomId);

    }
}
