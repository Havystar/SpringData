package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Address address;

    @OneToMany(mappedBy = "staff")
    List<Payment> payments;
    @OneToMany(mappedBy = "staff")
    private List<Rental> rentals;
}
