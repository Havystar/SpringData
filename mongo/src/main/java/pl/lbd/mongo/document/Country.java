package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Document
@NoArgsConstructor
public class Country {

    @Id
    private String id;
    private String country;
    private LocalDate lastUpdate;

    public Country(String country, LocalDate lastUpdate) {
        this.country = country;
        this.lastUpdate = lastUpdate;
    }
}
