package com.pathFinder.demo.service.impl;

import com.pathFinder.demo.domain.entity.User;
import com.pathFinder.demo.repository.UserRepository;
import com.pathFinder.demo.service.KakaoLoginService;
import com.pathFinder.demo.service.SessionLoginService;
import com.pathFinder.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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
    private final SessionLoginService sessionLoginService;

    @Override
    public void login(String token, HttpServletRequest httpServletRequest) {
        User user = kakaoLoginService.getUser(token);

        Optional<User> optionalUser = userRepository.findById(user.getUserId());

        // userId와 일치하는 유저가 없으면 가입 처리
        if(optionalUser.isEmpty())
            userRepository.save(user);

        sessionLoginService.sessionLogin(user, httpServletRequest);
    }

    @Override
    public User findById(String token) {

        Long userId = kakaoLoginService.getUserId(token);

        Optional<User> optionalUser = userRepository.findById(userId);

        // userId와 일치하는 유저가 없으면 null 반환
        log.info(String.valueOf(optionalUser.orElse(null)));
        return optionalUser.orElse(null);

    }
}
