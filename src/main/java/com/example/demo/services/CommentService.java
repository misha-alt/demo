package com.example.demo.services;

import com.example.demo.model.Comment;

import java.util.List;

public interface CommentService {

    Comment createCommentMeth(Comment comment);

    List<Comment> getComments();

    void deleteComment(Long id);

    Comment getCommentBtId(Long id);
}
