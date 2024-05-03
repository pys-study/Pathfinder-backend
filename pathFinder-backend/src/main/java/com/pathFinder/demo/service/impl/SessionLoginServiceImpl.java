package com.pathFinder.demo.service.impl;

import com.pathFinder.demo.domain.entity.User;
import com.pathFinder.demo.service.SessionLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
@Transactional
public class SessionLoginServiceImpl implements SessionLoginService {
    @Override
    public void sessionLogin(User user, HttpServletRequest httpServletRequest) {
        // 로그인 성공 => 세션 생성

        // 세션을 생성하기 전에 기존의 세션을 파기
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true); // Session이 없으면 생성
        // 세션에 Userid를 넣어줌
        session.setAttribute("userId", user.getUserId());
        session.setMaxInactiveInterval(1800); // Session이 30분동안 유지

        // 세션 id와 저장된 객체 정보 출력
        log.info(session.getId() + ", " + session.getAttribute("memberId"));

        //세션 데이터 출력
        session.getAttributeNames().asIterator()
                .forEachRemaining(name -> log.info("session name={}, value={}", name, session.getAttribute(name)));

        log.info("sessionId={}", session.getId());
        log.info("getMaxInactiveInterval={}", session.getMaxInactiveInterval());
        log.info("creationTime={}", new Date(session.getCreationTime()));
        log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime()));
        log.info("isNew={}", session.isNew());
    }
}
