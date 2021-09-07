package com.example.springjpa.entity;

import com.example.springjpa.utils.Rating;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.EqualsMethod;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@Setter
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
    @OneToMany(mappedBy = "film",fetch = FetchType.EAGER)
    Set<FilmCategory> filmCategory;
    @OneToMany(mappedBy = "film")
    private List<Inventory> inventories;
    @OneToMany(mappedBy = "film",fetch = FetchType.EAGER)
    private List<FilmActor> filmActors;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "language_id")
    private Language language;

    public Film(LocalDate lastUpdate, String title, String description, LocalDate releaseYear, int rentalDuration,
                double rental_rate, int length, double replacement_cost,
                Rating rating, String special_features, List<Inventory> inventories, List<FilmActor> filmActors, Language language, Set<FilmCategory> filmCategory) {
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
        this.filmCategory = filmCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return getRentalDuration() == film.getRentalDuration() && Double.compare(film.getRental_rate(), getRental_rate()) == 0 && getLength() == film.getLength() && Double.compare(film.getReplacement_cost(), getReplacement_cost()) == 0 && Objects.equals(getLastUpdate(), film.getLastUpdate()) && Objects.equals(getTitle(), film.getTitle()) && Objects.equals(getDescription(), film.getDescription()) && Objects.equals(getReleaseYear(), film.getReleaseYear()) && getRating() == film.getRating() && Objects.equals(getSpecial_features(), film.getSpecial_features());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLastUpdate(), getTitle(), getDescription(), getReleaseYear(), getRentalDuration(), getRental_rate(), getLength(), getReplacement_cost(), getRating(), getSpecial_features());
    }
}
