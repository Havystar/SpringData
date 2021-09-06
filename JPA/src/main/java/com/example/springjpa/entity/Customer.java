package com.example.springjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean activebool;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private Boolean active;
    @OneToOne
    Rental rental;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "store_id")
    private Store store;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer(String firstName, String lastName, String email, Boolean activebool, LocalDateTime createDate, LocalDateTime lastUpdate, Boolean active, Rental rental, Store store, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activebool = activebool;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.active = active;
        this.rental = rental;
        this.store = store;
        this.address = address;
    }
}
