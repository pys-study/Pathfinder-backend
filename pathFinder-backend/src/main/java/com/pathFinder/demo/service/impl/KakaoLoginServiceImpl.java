package com.pathFinder.demo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pathFinder.demo.domain.entity.User;
import com.pathFinder.demo.service.KakaoLoginService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class KakaoLoginServiceImpl implements KakaoLoginService {

    public JsonNode getJsonNode(String token) throws JsonProcessingException {

        log.info(token);

        // 사용자 정보를 받아오기 위한 RestTemplate를 사용해서 응답 받기
        RestTemplate restTemplate = new RestTemplate();

        // HttpHeader 오브젝트 생성
        HttpHeaders httpHeaders = new HttpHeaders();
        //Content-type 을 HttpHeader에 담는다는 것은 내가 담을 데이터가 key-value 데이터라고 알려주는 것이다
        httpHeaders.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        httpHeaders.add("Authorization", "Bearer " + token);

        //httpBody 생성 부분
        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest =
                new HttpEntity<>(httpHeaders);
        //Http 요청하기 - POST방식 그리고 response 변수의 응답을 받음
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "https://kapi.kakao.com/v2/user/me",  //요청 주소
                HttpMethod.POST,    //요청방법
                kakaoProfileRequest,  //넘기는 데이터
                String.class    //받아올 데이터 타입
        );

        log.info(String.valueOf(responseEntity));

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readTree(responseEntity.getBody());

    }

    // 토큰에 부합하는 유저 아이디만 반환
    @SneakyThrows
    public Long getUserId(String token)  {
        JsonNode jsonNode = getJsonNode(token);

        return jsonNode.get("id").asLong();
    }

    // 토큰에 부합하는 유저 닉네임만 반환
    @SneakyThrows
    public String getUserName(String token) {
        JsonNode jsonNode = getJsonNode(token);

        return jsonNode.get("properties").get("nickname").asText();
    }

    // 토큰에 부합하는 유저 반환
    @SneakyThrows
    public User getUser(String token) {
        JsonNode jsonNode = getJsonNode(token);

        return User.builder()
                .userId(jsonNode.get("id").asLong())
                .name(jsonNode.get("properties").get("nickname").asText())
                .build();
    }


}
