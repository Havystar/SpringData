package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document
@NoArgsConstructor
public class Language {
    @Id
    private String languageId;
    private String name;
    private LocalDate lastUpdate;
    private List<Film> films;

    public Language(String name, LocalDate lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Language(String name, LocalDate lastUpdate, List<Film> films) {
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.films = films;
    }
}
