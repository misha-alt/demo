package com.example.demo.controllers;

import com.example.demo.model.Comment;
import com.example.demo.model.User;
import com.example.demo.services.CommentService;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@Transactional
@RequestMapping("/comment")
public class CreateAndSafeComments {


    private CommentService commentService;
    private UserService userService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment, Principal principal){

        // Получаем имя пользователя из Principal
        String username = principal.getName();



         User user = userService.getUserByLogin(username); // Метод для поиска пользователя
        comment.setLoginOfCreator(user.getLogin());
        //User user =userService.getUserById(1L);

        LocalDate date = LocalDate.now();

        comment.setDate(date.toString());



        // Устанавливаем пользователя в комментарий
        comment.setUser(user);


        Comment savedComment = commentService.createCommentMeth(comment);
        commentService.getComments().forEach(comment1-> System.out.println(comment1.getComment()));



        return new ResponseEntity<>(savedComment,  HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List> getAllComment(){
       List<Comment>commentList= commentService.getComments();
       return ResponseEntity.ok(commentList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long id, Principal principal){

       Comment comment= commentService.getCommentBtId(id);

        // Проверить права на удаление коментария текущего пользователя
        String username = principal.getName();
        if (!comment.getLoginOfCreator().equals(username)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not allowed to delete this comment");
        }

        comment.setUser(null);
        commentService.deleteComment(id);

        return ResponseEntity.ok("Comment deleted successfully");

    }

}
