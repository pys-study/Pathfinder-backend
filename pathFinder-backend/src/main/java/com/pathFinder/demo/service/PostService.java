package com.pathFinder.demo.service;

import com.pathFinder.demo.domain.dto.PostRequestDto;
import com.pathFinder.demo.domain.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostLists();
    Post createPost(Long userId, PostRequestDto postRequestDto);
    Post readPost(Long postId);
    Post updatePost(Long userId, Long postId, PostRequestDto postRequestDto);
    void deletePost(Long postId);

}
