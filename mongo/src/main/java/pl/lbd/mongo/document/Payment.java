package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Document
@NoArgsConstructor
public class Payment {
    @Id
    private String paymentId;
    private Double amount;
    private LocalDate paymentDate;
    private Staff staff;

    public Payment(Double amount, LocalDate paymentDate, Staff staff) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.staff = staff;
    }
}
