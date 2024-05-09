package com.pathFinder.demo.service.impl;

import com.pathFinder.demo.domain.dto.CommentDto;
import com.pathFinder.demo.domain.entity.Comment;
import com.pathFinder.demo.domain.entity.Post;
import com.pathFinder.demo.domain.entity.User;
import com.pathFinder.demo.repository.CommentRepository;
import com.pathFinder.demo.repository.PostRepository;
import com.pathFinder.demo.repository.UserRepository;
import com.pathFinder.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public List<Comment> getCommentList() {
        return commentRepository.findAll();
    }
    @Override
    public Comment createComment(Long userId, Long postId, CommentDto commentDto) {
        if (userRepository.findById(userId).isEmpty())
            return null;

        User user = userRepository.findById(userId).get();
        Post post = postRepository.findById(postId).get();
        Comment comment = commentDto.toEntity(user, post);
        commentRepository.save(comment);

        return comment;
    }
    @Override
    public Comment updateComment(Long userId, Long postId, Long commentId, CommentDto commentDto) {
        if (userRepository.findById(userId).isEmpty())
            return null;

        User user = userRepository.findById(userId).get();
        Post post = postRepository.findById(postId).get();
        Comment comment = commentDto.toEntity(user, post);
        commentRepository.save(comment);

        return comment;
    }
    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
