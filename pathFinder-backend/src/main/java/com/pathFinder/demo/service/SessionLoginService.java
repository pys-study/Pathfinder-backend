package com.pathFinder.demo.service;

import com.pathFinder.demo.domain.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public interface SessionLoginService {
    void sessionLogin(User user, HttpServletRequest httpServletRequest);
}
