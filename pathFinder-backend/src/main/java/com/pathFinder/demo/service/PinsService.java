package com.pathFinder.demo.service;

import com.pathFinder.demo.domain.dto.PinsDto;
import com.pathFinder.demo.domain.entity.Pins;

import java.util.List;

public interface PinsService {

    List<Pins> getPins(Long userId);
    List<Pins> savePins(Long userId, List<PinsDto> pinsDtos);
    List<Pins> deletePins(Long userId, List<Pins> pins);

}
