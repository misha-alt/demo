package com.example.demo.services;

import com.example.demo.model.Comment;
import com.example.demo.model.Product;
import com.example.demo.repository.CommentRepo;
import exeptions.ResurceNotFoundExeption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class CommentServiceImpl implements CommentService{

    private CommentRepo commentRepo;

    @Override
    public Comment createCommentMeth(Comment comment) {
        Comment savedComment = commentRepo.save(comment);
        return savedComment;
    }

    @Override
    public List<Comment> getComments() {

        List<Comment> commentList= commentRepo.findAll();

        return commentList;
    }

    @Override
    public void deleteComment(Long id) {
        //Comment comment = commentRepo.findById(id).orElseThrow(()->new ResurceNotFoundExeption("Comment is not exist with" + id));
        commentRepo.deleteById(id);
    }

    @Override
    public Comment getCommentBtId(Long id) {
       Comment comment= commentRepo.findById(id).orElseThrow(()->new ResurceNotFoundExeption("Comment is not exist with" + id));
        return comment;
    }
}
