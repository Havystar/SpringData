package com.example.springjpa.entity;

import com.example.springjpa.embedableKey.FilmActorKey;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
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

    public void setId() {

        this.id=new FilmActorKey(this.film.getFilmId(),this.actor.getActorId());
    }

    public FilmActor(Film film, Actor actor, LocalDateTime lastUpdate) {
        this.film = film;
        this.actor = actor;
        this.lastUpdate = lastUpdate;
    }
}
