package com.example.springjpa.embedableKey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class FilmActorKey implements Serializable {
    @Column(name = "actor_id")
    private Long actorId;
    @Column(name="film_id")
    private Long filmId;

    public FilmActorKey(long filmId, Long actorId) {
        this.actorId=actorId;
        this.filmId=filmId;
    }
    public FilmActorKey()
    {

    }
}
