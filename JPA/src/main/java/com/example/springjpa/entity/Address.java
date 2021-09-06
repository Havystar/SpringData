package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
public class Address {

    @Id
    private Long id;

    @ManyToOne
    private City city;

}
