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
    private Rental rental;

    public Inventory(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Inventory(Store store, LocalDate lastUpdate, Rental rental) {
        this.store = store;
        this.lastUpdate = lastUpdate;
        this.rental = rental;
    }
}
