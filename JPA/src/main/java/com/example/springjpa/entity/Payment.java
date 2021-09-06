package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Double amount;
    private LocalDateTime paymentDate;
    @ManyToOne
    @NotNull
    Customer customer;
    @ManyToOne
    @NotNull
    private Staff staff;
    @ManyToOne
    @NotNull
    private Rental rental;

}
