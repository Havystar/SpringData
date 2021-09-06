package com.example.springjpa.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;
    @OneToMany(mappedBy = "actor")
    private List<FilmActor> filmActors;
}
