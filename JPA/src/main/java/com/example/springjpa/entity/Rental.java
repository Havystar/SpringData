package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;
    private LocalDate lastUpdate;
    private LocalDate returnDate;
    private LocalDate rentalDate;
    @OneToOne
    @NotNull
    private Customer customer;
    @ManyToOne
    @NotNull
    private Inventory inventory;
    @ManyToOne
    @NotNull
    private Staff staff;
    @OneToMany(mappedBy = "rental")
    private List<Payment> payments;
}