package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
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
    private Customer customer;
    @ManyToOne
    private Inventory inventory;
    @ManyToOne
    private Staff staff;
    @OneToMany(mappedBy = "rental")
    private List<Payment> payments;
}