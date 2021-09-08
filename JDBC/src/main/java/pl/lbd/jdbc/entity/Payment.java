package pl.lbd.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class Payment {
    @Id
    private Long paymentId;
    private Double amount;
    private LocalDateTime paymentDate;
    private Customer customer;
    private Staff staff;
    private Rental rental;

    public Payment(Double amount, LocalDateTime paymentDate, Customer customer, Staff staff, Rental rental) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.customer = customer;
        this.staff = staff;
        this.rental = rental;
    }
}
