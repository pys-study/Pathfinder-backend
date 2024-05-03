package com.pathFinder.demo.domain.dto;

import com.pathFinder.demo.domain.entity.Pins;
import com.pathFinder.demo.domain.entity.User;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PinsDto {

    private String pinName;

    private Float pinPositionX;

    private Float pinPositionY;

    public Pins toEntity(User user) {
        return Pins.builder()
                .user(user)
                .pinName(this.pinName)
                .pinPositionX(this.pinPositionX)
                .pinPositionY(this.pinPositionY).build();
    }
}
