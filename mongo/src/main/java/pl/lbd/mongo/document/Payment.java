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

    public Payment(Double amount, LocalDate paymentDate) {
        this.amount = amount;
        this.paymentDate = paymentDate;
    }
}
