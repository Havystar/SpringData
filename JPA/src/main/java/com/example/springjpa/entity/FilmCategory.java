package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class FilmCategory {
    @EmbeddedId
    FilmCategoryKey id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    Film film;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    Category category;
    private LocalDate lastUpdate;

}
