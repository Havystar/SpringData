package com.example.springjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;
    private LocalDate lastUpdate;
    private LocalDate returnDate;
    private LocalDate rentalDate;
    @OneToOne
    @JoinColumn(name = "customer_id")
    @NotNull
    private Customer customer;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @OneToMany(mappedBy = "rental")
    private List<Payment> payments;

    public Rental(LocalDate lastUpdate, LocalDate returnDate, LocalDate rentalDate, Customer customer, Inventory inventory, Staff staff, List<Payment> payments) {
        this.lastUpdate = lastUpdate;
        this.returnDate = returnDate;
        this.rentalDate = rentalDate;
        this.customer = customer;
        this.inventory = inventory;
        this.staff = staff;
        this.payments = payments;
    }
}