package pl.lbd.jdbc.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.time.LocalDate;
import java.util.List;


@Data

@NoArgsConstructor
public class Inventory {
    @Id
    private Long inventoryId;
    private Rental rental;
    private LocalDate lastUpdate;
    private Store store;
    private Film film;
    private List<Rental> rentals;
    public Inventory(Rental rental, LocalDate lastUpdate, Store store, Film film, List<Rental> rentals) {
        this.rental = rental;
        this.lastUpdate = lastUpdate;
        this.store = store;
        this.film = film;
        this.rentals = rentals;
    }
}
