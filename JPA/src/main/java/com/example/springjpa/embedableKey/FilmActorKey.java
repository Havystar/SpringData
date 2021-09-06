package com.example.springjpa.embedableKey;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class FilmActorKey implements Serializable {
    private Long actorId;
    private Long filmId;
}
