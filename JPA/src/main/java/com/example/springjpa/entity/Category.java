package com.example.springjpa.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;
    private String name;
    private LocalDate lastUpdate;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    Set<FilmCategory> filmCategory;

    public Category(String name, LocalDate lastUpdate, Set<FilmCategory> filmCategory) {
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.filmCategory = filmCategory;
    }
}