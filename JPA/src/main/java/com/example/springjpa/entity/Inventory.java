package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Data
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    @OneToOne()
    private Rental rental;
    private LocalDate lastUpdate;
    @ManyToOne
    @NotNull
    private Store store;
    @ManyToOne
    @NotNull
    private Film film;
    @OneToMany(mappedBy = "inventory")
    private List<Rental> rentals;
}
