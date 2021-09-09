package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
@NoArgsConstructor
public class Inventory {
    @Id
    private String inventoryId;
    private Store store;
    private LocalDate lastUpdate;

    public Inventory(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
