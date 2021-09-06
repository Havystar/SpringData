package com.example.springjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
    @NotNull
    @JoinColumn(name = "city_id")
    private City city;
    @OneToMany(mappedBy = "address")
    private List<Customer> customers;
    @OneToMany(mappedBy = "address")
    private List<Staff> staffList;

    public Address(String address, String address2, String district, String postalCode, String phone, LocalDateTime lastUpdate, City city, List<Customer> customers, List<Staff> staffList) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
        this.city = city;
        this.customers = customers;
        this.staffList = staffList;
    }
}
