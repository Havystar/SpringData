package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    @OneToOne
    private Store store;
    @ManyToOne
    private Address address;

    @OneToMany(mappedBy = "staff")
    List<Payment> payments;
    @OneToMany(mappedBy = "staff")
    private List<Rental> rentals;
}
