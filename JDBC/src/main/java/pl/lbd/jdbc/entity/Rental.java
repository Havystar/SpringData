package pl.lbd.jdbc.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data

@NoArgsConstructor
public class Rental {

    @Id
    private Long rentalId;
    private LocalDate lastUpdate;
    private LocalDate returnDate;
    private LocalDate rentalDate;
    private Customer customer;
    private Inventory inventory;
    private Staff staff;
    private List<Payment> payments;

    public Rental(LocalDate lastUpdate, LocalDate returnDate, LocalDate rentalDate, Customer customer, Inventory inventory, Staff staff, List<Payment> payments) {
        this.lastUpdate = lastUpdate;
        this.returnDate = returnDate;
        this.rentalDate = rentalDate;
        this.customer = customer;
        this.inventory = inventory;
        this.staff = staff;
        this.payments = payments;
    }
}