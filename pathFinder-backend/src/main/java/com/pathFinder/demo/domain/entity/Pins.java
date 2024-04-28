package com.pathFinder.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pins {

    @Id
    @GeneratedValue
    private Long pinId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private String pinName;

    private Float pinPositionX;

    private Float pinPositionY;

}
