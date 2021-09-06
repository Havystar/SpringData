package com.example.springjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;
    private String name;
    private LocalDate lastUpdate;
    @OneToMany(mappedBy = "category")
    Set<FilmCategory> filmCategory;

    public Category(String name, LocalDate lastUpdate, Set<FilmCategory> filmCategory) {
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.filmCategory = filmCategory;
    }
}