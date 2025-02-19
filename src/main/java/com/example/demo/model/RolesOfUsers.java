package com.example.demo.model;

/*import jakarta.persistence.*;*/
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ROLESOFUSERS")
public class RolesOfUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable =  false)
    private Long id;

    @Column(name = "rolename")
    private String rolename;



    @ManyToMany(/*cascade = CascadeType.ALL,*//*fetch = FetchType.EAGER,*/ mappedBy = "authority")
    @JsonIgnore
    private Set<User> userSet = new HashSet<>();


}
