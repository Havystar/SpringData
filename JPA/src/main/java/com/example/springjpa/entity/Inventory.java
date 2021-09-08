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
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
    private LocalDate lastUpdate;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "store_id")
    private Store store;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @OneToMany(mappedBy = "inventory")
    private List<Rental> rentals;

    public Inventory(Rental rental, LocalDate lastUpdate, Store store, Film film, List<Rental> rentals) {
        this.rental = rental;
        this.lastUpdate = lastUpdate;
        this.store = store;
        this.film = film;
        this.rentals = rentals;
    }
}
