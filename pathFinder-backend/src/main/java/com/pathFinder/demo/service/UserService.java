package com.pathFinder.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pathFinder.demo.domain.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    void login(String token, HttpServletRequest httpServletRequest);
    public
    User findById(String token);

}
