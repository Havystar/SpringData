package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    private Staff staff;
}
