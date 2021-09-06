package com.example.springjpa.entity;

import com.example.springjpa.embedableKey.FilmCategoryKey;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class FilmCategory {
    @EmbeddedId
    FilmCategoryKey id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    @NotNull
    Film film;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    @NotNull
    Category category;
    private LocalDate lastUpdate;

    public FilmCategory(Film film, Category category, LocalDate lastUpdate) {
        this.film = film;
        this.category = category;
        this.lastUpdate = lastUpdate;
    }
}
