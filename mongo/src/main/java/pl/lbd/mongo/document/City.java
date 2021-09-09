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
public class City {
    @Id
    private String id;
    private String city;
    private LocalDate lastUpdate;

    public City(String city, LocalDate lastUpdate) {
        this.city = city;
        this.lastUpdate = lastUpdate;
    }
}
