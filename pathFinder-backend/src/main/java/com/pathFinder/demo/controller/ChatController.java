package com.pathFinder.demo.controller;

import com.pathFinder.demo.domain.dto.ChatDto;
import com.pathFinder.demo.domain.entity.Chat;
import com.pathFinder.demo.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/get/{chattingRoomId}")
    @ResponseBody
    public List<Chat> getChat(@SessionAttribute(name = "userId", required = false) Long userId,
                              @PathVariable(value = "chattingRoomId") Long chattingRoomId) {
        return chatService.getChat(userId, chattingRoomId);
    }

    @PostMapping("/add/{chattingRoomId}")
    @ResponseBody
    public Chat addChat(@SessionAttribute(name = "userId", required = false) Long userId,
                        @PathVariable(value = "chattingRoomId") Long chattingRoomId,
                        @ModelAttribute ChatDto chatDto) {
        return chatService.saveChat(userId, chattingRoomId, chatDto);
    }

}
