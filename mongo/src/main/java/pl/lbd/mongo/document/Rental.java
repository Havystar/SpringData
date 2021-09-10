package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Document
@NoArgsConstructor
public class Rental {

    @Id
    private String rentalId;
    private LocalDate lastUpdate;
    private LocalDate returnDate;
    private LocalDate rentalDate;
    private Customer customer;
    public Rental(LocalDate lastUpdate, LocalDate returnDate, LocalDate rentalDate) {
        this.lastUpdate = lastUpdate;
        this.returnDate = returnDate;
        this.rentalDate = rentalDate;
    }
    public Rental(Rental rental,Customer customer)
    {
        this.lastUpdate = rental.lastUpdate;
        this.returnDate = rental.returnDate;
        this.rentalDate = rental.rentalDate;
        this.customer=customer;
    }
}