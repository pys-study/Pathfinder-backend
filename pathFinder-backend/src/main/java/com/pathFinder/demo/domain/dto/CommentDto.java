package com.pathFinder.demo.domain.dto;

import com.pathFinder.demo.domain.entity.Comment;
import com.pathFinder.demo.domain.entity.Post;
import com.pathFinder.demo.domain.entity.User;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDto {

    private String content;

    private LocalDate date;

    public Comment toEntity(User user, Post post) {
        return Comment.builder()
                .user(user)
                .post(post)
                .content(this.content)
                .date(this.date).build();
    }
}
