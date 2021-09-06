package com.example.springjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;
    private String name;
    private LocalDate lastUpdate;
    @OneToMany(mappedBy = "language", fetch = FetchType.EAGER)
    private List<Film> film;

    public Language(String name, LocalDate lastUpdate, List<Film> film) {
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.film = film;
    }
}
