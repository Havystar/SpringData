package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;


@Entity
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long filmId;
    private LocalDate lastUpdate;
    @OneToMany(mappedBy = "film")
    Set<FilmCategory> filmCategory;

}
