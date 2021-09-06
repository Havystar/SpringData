package com.example.springjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Double amount;
    private LocalDateTime paymentDate;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "customer_id")
    Customer customer;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "rental_id")
    private Rental rental;

    public Payment(Double amount, LocalDateTime paymentDate, Customer customer, Staff staff, Rental rental) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.customer = customer;
        this.staff = staff;
        this.rental = rental;
    }
}
