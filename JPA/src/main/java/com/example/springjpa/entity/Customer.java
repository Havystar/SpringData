package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean activebool;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private Boolean active;
    @ManyToOne
    private Store store;
    @ManyToOne
    private Address address;



}
