package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long filmId;
    private LocalDate lastUpdate;
    private String title;
    private String description;
    private LocalDate releaseYear;
    private int rentalDuration;
    private double rental_rate;
    private int length;
    private double replacement_cost;
    private String  rating;
    private String special_features;

    @OneToMany(mappedBy = "film")
    private List<FilmActor> filmActors;
    @ManyToOne()
    private Language language;

}
