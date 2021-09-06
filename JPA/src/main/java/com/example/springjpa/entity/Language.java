package com.example.springjpa.entity;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;
    private String Name;
    private LocalDate lastUpdate;
    @OneToMany(mappedBy = "language")
    private List<Film> film;
}
