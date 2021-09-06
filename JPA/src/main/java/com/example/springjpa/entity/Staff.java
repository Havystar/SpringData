package com.example.springjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    @OneToOne
    private Store store;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "staff")
    List<Payment> payments;
    @OneToMany(mappedBy = "staff")
    private List<Rental> rentals;

    public Staff(Store store, Address address, List<Payment> payments, List<Rental> rentals) {
        this.store = store;
        this.address = address;
        this.payments = payments;
        this.rentals = rentals;
    }
}
