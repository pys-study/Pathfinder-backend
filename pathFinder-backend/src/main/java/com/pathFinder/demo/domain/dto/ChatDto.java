package com.pathFinder.demo.domain.dto;


import com.pathFinder.demo.domain.entity.Chat;
import com.pathFinder.demo.domain.entity.ChattingRoom;
import com.pathFinder.demo.domain.entity.User;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatDto {

    private String content;

    private LocalDate date;

    private boolean isUserChat;

    public Chat toEntity(User user, ChattingRoom chattingRoom) {
        return Chat.builder()
                .chattingRoom(chattingRoom)
                .user(user)
                .content(this.content)
                .date(this.date)
                .isUserChat(this.isUserChat).build();
    }

}
