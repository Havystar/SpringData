package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;
    private LocalDateTime lastUpdate;
    @ManyToOne
    private City city;

}
