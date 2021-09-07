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

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<City> cities;

    public Country(String country, LocalDateTime lastUpdate, List<City> cities) {
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.cities = cities;
    }


    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
