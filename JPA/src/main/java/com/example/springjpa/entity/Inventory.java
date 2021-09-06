package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
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
<<<<<<< HEAD
    private Store store;
    @ManyToOne
=======
>>>>>>> 483520fbdbb43f5f4f33828ab97a66e670fccec2
    private Film film;
    @OneToMany(mappedBy = "inventory")
    private List<Rental> rentals;
}
