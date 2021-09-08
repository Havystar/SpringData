package com.example.springjpa.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    @OneToOne
    @JoinColumn(name = "manager_staff_id")
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

    public Store(Staff managerStaffId, Address address, LocalDateTime lastUpadte, List<Customer> customers, List<Inventory> inventories) {
        this.managerStaffId = managerStaffId;
        this.address = address;
        this.lastUpadte = lastUpadte;
        this.customers = customers;
        this.inventories = inventories;
    }
}
