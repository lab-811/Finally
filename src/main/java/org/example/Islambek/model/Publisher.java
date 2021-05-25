package org.example.Islambek.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToOne(mappedBy = "publisher", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "product-publisher")
    private Book book;

}
