package com.example.demo.model;

/*import jakarta.persistence.*;*/
import lombok.*;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

    @Column(name = "role_name")
    private String role_name;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "authority")
    private Set<User> userSet;
}
