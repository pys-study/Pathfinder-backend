package com.pathFinder.demo.controller;

import com.pathFinder.demo.domain.dto.CommentDto;
import com.pathFinder.demo.domain.entity.Comment;
import com.pathFinder.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/")
    @ResponseBody
    public List<Comment> getPostLists() {
        return commentService.getCommentList();
    }

    @PostMapping("/create")
    @ResponseBody
    public Comment createComment(@SessionAttribute(name = "userId", required = false) Long userId,
                              Long postId,
                              @ModelAttribute CommentDto commentDto) {
        return commentService.createComment(userId, postId, commentDto);
    }

    @PutMapping("/{commentId}")
    @ResponseBody
    public Comment updatePost(@SessionAttribute(name = "userId", required = false) Long userId,
                           long postId,
                           @PathVariable long commentId,
                           @ModelAttribute CommentDto commentDto) {
        return commentService.updateComment(userId, postId, commentId, commentDto);
    }

    @DeleteMapping("/{commentId}")
    @ResponseBody
    public void deleteComment(@PathVariable long commentId) {
        commentService.deleteComment(commentId);
    }
}
