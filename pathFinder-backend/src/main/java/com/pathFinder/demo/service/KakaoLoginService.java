package com.pathFinder.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.pathFinder.demo.domain.entity.User;

public interface KakaoLoginService {
    JsonNode getJsonNode(String token) throws JsonProcessingException;

    public Long getUserId(String token);

    public String getUserName(String token);

    public User getUser(String token);
}
