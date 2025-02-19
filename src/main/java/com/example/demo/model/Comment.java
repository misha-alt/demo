package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="COMMENT")
public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(unique = true, nullable =  false)
        private Long id;

        @Column(name="comment")
        private String comment;

        @Column(name = "comment_date")
        private String date;

        @Column(name = "loginOfCreator")
        private String loginOfCreator;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    }

