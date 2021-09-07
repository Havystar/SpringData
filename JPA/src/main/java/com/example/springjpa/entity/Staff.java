package com.example.springjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Store store;
    private String firtName;
    private String lastName;
    private String email;
    private Boolean active;
    private String username;
    private String password;
    private LocalDate lastUpdate;
    private String picture;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "staff")
    List<Payment> payments;
    @OneToMany(mappedBy = "staff")
    private List<Rental> rentals;


    public Staff(Store store, String firtName, String lastName, String email, Boolean active, String username, String password,
                 LocalDate lastUpdate, String picture, Address address, List<Payment> payments, List<Rental> rentals) {
        this.store = store;
        this.firtName = firtName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.picture = picture;
        this.address = address;
        this.payments = payments;
        this.rentals = rentals;
    }
}
