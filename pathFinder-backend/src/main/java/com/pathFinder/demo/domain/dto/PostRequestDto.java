package com.pathFinder.demo.domain.dto;

import com.pathFinder.demo.domain.entity.Post;
import com.pathFinder.demo.domain.entity.User;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class PostRequestDto {

    private Long postId;

    private String title;

    private String content;

    private LocalDate date;

    public Post toEntity(User user) {
        return Post.builder()
                .user(user)
                .postId(this.postId)
                .title(this.title)
                .content(this.content)
                .date(this.date).build();
    }
}
