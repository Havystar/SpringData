package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
@NoArgsConstructor
public class Store {

    @Id
    private String storeId;
    private LocalDate lastUpdate;

    public Store(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
