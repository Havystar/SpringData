package com.example.springjpa.entity;

import com.example.springjpa.utils.Rating;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private Rating rating;
    private String special_features;
    @OneToMany(mappedBy = "film")
    private List<Inventory> inventories;
    @OneToMany(mappedBy = "film")
    private List<FilmActor> filmActors;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "language_id")
    private Language language;

    public Film(LocalDate lastUpdate, String title, String description, LocalDate releaseYear, int rentalDuration,
                double rental_rate, int length, double replacement_cost,
                Rating rating, String special_features, List<Inventory> inventories, List<FilmActor> filmActors, Language language) {
        this.lastUpdate = lastUpdate;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
        this.inventories = inventories;
        this.filmActors = filmActors;
        this.language = language;
    }
}
