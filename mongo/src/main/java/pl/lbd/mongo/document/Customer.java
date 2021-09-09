package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document
@NoArgsConstructor
public class Customer {
    @Id
    private String customer_id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean activebool;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private Boolean active;


    public Customer(String firstName, String lastName, String email, Boolean activebool, LocalDateTime createDate, LocalDateTime lastUpdate, Boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activebool = activebool;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.active = active;
    }
}
