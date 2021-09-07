package com.example.springjpa.entity;

import com.example.springjpa.embedableKey.FilmCategoryKey;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FilmCategory {
    @EmbeddedId
    FilmCategoryKey id;
    public void setId() {
        this.id = new FilmCategoryKey(film.getFilmId(), category.getCategoryId());
    }

    @ManyToOne()
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    @NotNull
    Film film;

    @ManyToOne()
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
