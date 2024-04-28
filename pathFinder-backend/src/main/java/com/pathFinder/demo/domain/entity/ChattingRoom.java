package com.pathFinder.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChattingRoom {

    @Id
    @GeneratedValue
    private Long chattingRoomId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
