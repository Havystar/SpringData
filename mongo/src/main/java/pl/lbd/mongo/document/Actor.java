package pl.lbd.mongo.document;

import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@NoArgsConstructor
public class Actor {
    @Id
    private String actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;

    public Actor(String firstName, String lastName, LocalDateTime lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }
}
