package com.example.springjpa.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    @OneToOne
    @NotNull
    private Staff managerStaffId;
    @OneToOne
    @NotNull
    private Address address;
    private LocalDateTime lastUpadte;
    @OneToMany(mappedBy = "store")
    List<Customer> customers;
    @OneToMany(mappedBy = "store")
    List<Inventory>inventories;
}
