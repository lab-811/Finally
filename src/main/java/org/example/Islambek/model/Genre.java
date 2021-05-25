package org.example.Islambek.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToOne(mappedBy = "genre", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "product-genre")
    private Book book;


}
