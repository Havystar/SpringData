package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    @OneToOne
    private Store store;
}
