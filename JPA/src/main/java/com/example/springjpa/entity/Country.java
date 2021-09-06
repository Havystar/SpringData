package com.example.springjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String country;
    LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    public Country(String country, LocalDateTime lastUpdate, List<City> cities) {
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.cities = cities;
    }
}
