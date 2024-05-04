package com.pathFinder.demo.service.impl;

import com.pathFinder.demo.domain.dto.PinsDto;
import com.pathFinder.demo.domain.entity.Pins;
import com.pathFinder.demo.domain.entity.User;
import com.pathFinder.demo.repository.PinsRepository;
import com.pathFinder.demo.repository.UserRepository;
import com.pathFinder.demo.service.PinsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PinsServiceImpl implements PinsService {

    private final PinsRepository pinsRepository;
    private final UserRepository userRepository;

    @Override
    public List<Pins> getPins(Long userId) {
        // userId에 해당하는 회원 핀들을 조회
        return pinsRepository.findByUser_UserId(userId);
    }

    @Override
    public List<Pins> savePins(Long userId, List<PinsDto> pinsDtos) {

        // 회원 정보가 없으면 null 반환
        if (userRepository.findById(userId).isEmpty())
            return null;

        User user = userRepository.findById(userId).get();
        List<Pins> savedPins = null;

        for (PinsDto pinsDto : pinsDtos)
            savedPins.add(pinsDto.toEntity(user));
        pinsRepository.saveAll(Objects.requireNonNull(savedPins));

        log.info(savedPins.toString());
        return savedPins; // 저장된 핀 반환
    }

    @Override
    public List<Pins> deletePins(Long userId, List<Pins> pins) {
        // 회원 정보가 없으면 null 반환
        if (userRepository.findById(userId).isEmpty())
            return null;

        User user = userRepository.findById(userId).get();

        List<Pins> deletedPins = null;

        for(Pins pin : pins){

            // 자신의 핀이 아니면 삭제하지 않음
            if(pin.getUser() != user)
                continue;

            pinsRepository.delete(pin);
            deletedPins.add(pin);

        }

        log.info(Objects.requireNonNull(deletedPins).toString());
        return deletedPins; // 삭제된 핀 반환
    }
}
