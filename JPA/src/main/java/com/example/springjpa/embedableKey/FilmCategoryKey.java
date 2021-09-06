package com.example.springjpa.embedableKey;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Embeddable
@Data
public class FilmCategoryKey implements Serializable {
    @Column(name = "film_id")
    private long filmId;
    @Column(name = "category_id")
    private long categoryId;

    public FilmCategoryKey(long filmId, long categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }

    public FilmCategoryKey() {
    }
}
