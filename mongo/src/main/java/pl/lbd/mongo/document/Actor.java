package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document
@NoArgsConstructor
public class Actor {
    @Id
    private String actorId;
    private String firstName;
    private String lastName;
    private LocalDate lastUpdate;
    private List<Film> films;

    public Actor(String firstName, String lastName, LocalDate lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public Actor(String firstName, String lastName, LocalDate lastUpdate, List<Film> films) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
        this.films = films;
    }

    public Actor(Actor actor, List<Film> films) {
        this.actorId = actor.getActorId();
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
        this.lastUpdate = actor.getLastUpdate();
        this.films = films;
    }
}
