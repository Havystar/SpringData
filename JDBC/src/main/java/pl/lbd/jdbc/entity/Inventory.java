package pl.lbd.jdbc.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;


import java.time.LocalDate;
import java.util.List;


@Data

@NoArgsConstructor
public class Inventory {
    @Id
    private Long inventoryId;
    private Rental rental;
    private LocalDate lastUpdate;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Store store;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Film film;

    public Inventory(Rental rental, LocalDate lastUpdate, Store store, Film film) {
        this.rental = rental;
        this.lastUpdate = lastUpdate;
        this.store = store;
        this.film = film;
    }
}
