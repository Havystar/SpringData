package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    LocalDateTime lastUpdate;
    @OneToMany(mappedBy = "city")
    private List<Address> addressList;
    @ManyToOne
    private Country country;

}
