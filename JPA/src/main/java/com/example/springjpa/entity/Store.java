package com.example.springjpa.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    @OneToOne
    private Staff managerStaffId;
    
}
