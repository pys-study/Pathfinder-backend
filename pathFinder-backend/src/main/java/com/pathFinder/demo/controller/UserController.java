package com.pathFinder.demo.controller;

import com.pathFinder.demo.domain.dto.tokenDto;
import com.pathFinder.demo.domain.entity.User;
import com.pathFinder.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

//    @PostMapping("/sign-in")


//    @PostMapping("/login")

    @PostMapping("/get")
    @ResponseBody
    public User findUser(@RequestBody tokenDto tokenDto){
        return userService.findById(tokenDto.getToken());
    }

//    @PostMapping("/sign-up")
//    @RequestBody
//

}
