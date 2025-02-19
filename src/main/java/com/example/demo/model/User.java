package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;
/*import jakarta.persistence.*;*/
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="USER")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable =  false)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "USERROLE_ID"))
    @JsonIgnore
    private Set<RolesOfUsers> authority =  new HashSet<>();;




    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Comment> commentSet;



}
