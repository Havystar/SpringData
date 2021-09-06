package com.example.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;


@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;
    private LocalDate lastUpdate;
    @OneToMany(mappedBy = "category")
    Set<FilmCategory> filmCategory;


}