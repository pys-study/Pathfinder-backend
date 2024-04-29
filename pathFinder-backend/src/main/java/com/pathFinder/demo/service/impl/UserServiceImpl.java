package com.pathFinder.demo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pathFinder.demo.domain.entity.User;
import com.pathFinder.demo.repository.UserRepository;
import com.pathFinder.demo.service.KakaoLoginService;
import com.pathFinder.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final KakaoLoginService kakaoLoginService;

    @Override
    public User findById(String token) {

        Long userId = kakaoLoginService.getUserId(token);

        Optional<User> optionalUser = userRepository.findById(userId);

        // userId와 일치하는 유저가 없으면 null 반환
        log.info(String.valueOf(optionalUser.orElse(null)));
        return optionalUser.orElse(null);

    }
}
