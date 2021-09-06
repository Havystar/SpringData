package com.example.springjpa.entity;

import com.example.springjpa.embedableKey.FilmActorKey;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class FilmActor {

    @EmbeddedId
    private FilmActorKey id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name="film_id")
    @NotNull
    private Film film;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name="actor_id")
    @NotNull
    private Actor actor;

    private LocalDateTime lastUpdate;

}
