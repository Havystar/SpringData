package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "city")
    private List<Address> addressList;

    @ManyToOne
    private Country country;

}
