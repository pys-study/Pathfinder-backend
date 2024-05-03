package com.pathFinder.demo.controller;

import com.pathFinder.demo.domain.dto.TokenDto;
import com.pathFinder.demo.domain.entity.User;
import com.pathFinder.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public void login(@ModelAttribute TokenDto tokenDto, HttpServletRequest httpServletRequest) {
        // 회원가입이 되어있지 않으면 자동으로 가입 처리
        userService.login(tokenDto.getToken(), httpServletRequest);
    }

    @PostMapping("/get")
    @ResponseBody
    public User findUser(@ModelAttribute TokenDto tokenDto) {
        return userService.findById(tokenDto.getToken());
    }

}
