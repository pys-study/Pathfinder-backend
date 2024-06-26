package com.pathFinder.demo.controller;

import com.pathFinder.demo.domain.dto.PostRequestDto;
import com.pathFinder.demo.domain.entity.Post;
import com.pathFinder.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    @ResponseBody
    public List<Post> getPostLists() {
        return postService.getPostLists();
    }

    @PostMapping("/create/{userId}")
    @ResponseBody
    public Post createPost(@PathVariable Long userId,
                           @ModelAttribute PostRequestDto postRequestDto) {
        return postService.createPost(userId, postRequestDto);
    }

    @GetMapping("/{postId}")
    @ResponseBody
    public Post readPost(@PathVariable long postId) {
        System.out.println("test");
        return postService.readPost(postId);
    }

    @PutMapping("/{postId}/{userId}")
    @ResponseBody
    public Post updatePost(@PathVariable long postId,
                           @PathVariable Long userId,
                           @ModelAttribute PostRequestDto postRequestDto) {
        return postService.updatePost(userId, postId, postRequestDto);
    }

    @DeleteMapping("/{postId}")
    @ResponseBody
    public void deletePost(@PathVariable long postId) {
        postService.deletePost(postId);
    }

}
