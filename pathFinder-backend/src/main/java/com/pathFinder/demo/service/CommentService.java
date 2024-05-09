package com.pathFinder.demo.service;

import com.pathFinder.demo.domain.dto.CommentDto;
import com.pathFinder.demo.domain.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentList();

    Comment createComment(Long userId, Long postId, CommentDto commentDto);

    Comment updateComment(Long userId, Long postId, Long commentId, CommentDto commentDto);

    void deleteComment(Long commentId);
}
