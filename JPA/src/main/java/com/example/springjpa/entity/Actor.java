package com.example.springjpa.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;
    @OneToMany(mappedBy = "actor")
    private List<FilmActor> filmActors;

    public Actor(String firstName, String lastName, LocalDateTime lastUpdate, List<FilmActor> filmActors) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
        this.filmActors = filmActors;
    }

}
