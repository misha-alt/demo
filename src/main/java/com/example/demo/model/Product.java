package com.example.demo.model;

/*import jakarta.persistence.*;*/
import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(unique = true, nullable =  false)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private int price;

    @Column(name="city")
    private String city;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;


}