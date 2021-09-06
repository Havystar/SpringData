package com.example.springjpa.entity;

import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class FilmCategory {
    @Id
    private long id;
    private long categoryId;
    private LocalDate lastUpdate;

}
