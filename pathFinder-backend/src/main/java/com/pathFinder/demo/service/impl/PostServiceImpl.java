package com.pathFinder.demo.service.impl;

import com.pathFinder.demo.domain.dto.PostRequestDto;
import com.pathFinder.demo.domain.entity.Post;
import com.pathFinder.demo.domain.entity.User;
import com.pathFinder.demo.repository.PostRepository;
import com.pathFinder.demo.repository.UserRepository;
import com.pathFinder.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public List<Post> getPostLists() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(Long userId, PostRequestDto postRequestDto) {
        // 회원 정보가 없으면 null 반환
        if (userRepository.findById(userId).isEmpty())
            return null;

        User user = userRepository.findById(userId).get();
        Post post = postRequestDto.toEntity(user);
        postRepository.save(post);

        return post;
    }
    @Override
    public Post readPost(Long postId) {
        System.out.println("test");
        return postRepository.findById(postId).orElse(null);
    }
    @Override
    public Post updatePost(Long userId, Long postId, PostRequestDto postRequestDto) {
        if (userRepository.findById(userId).isEmpty())
            return null;

        User user = userRepository.findById(userId).get();
        Post post = postRequestDto.toEntity(user);

        return postRepository.save(post);
    }
    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
