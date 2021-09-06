package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    @OneToMany(mappedBy = "address")
    private List<Customer> customers;
    @OneToMany(mappedBy = "address")
    private List<Staff> staffList;

}
