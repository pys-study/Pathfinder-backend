package com.pathFinder.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pathFinder.demo.domain.entity.User;

public interface UserService {

    User findById(String token);

}
