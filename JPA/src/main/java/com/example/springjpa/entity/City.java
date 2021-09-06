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
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    LocalDateTime lastUpdate;
    @OneToMany(mappedBy = "city")
    private List<Address> addressList;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "country_id")
    private Country country;

    public City(String city, LocalDateTime lastUpdate, List<Address> addressList, Country country) {
        this.city = city;
        this.lastUpdate = lastUpdate;
        this.addressList = addressList;
        this.country = country;
    }
}
