package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.List;

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
    private LocalDate createDate;
    private LocalDate lastUpdate;
    private Boolean active;
    private List<Payment> payment;
    private Address address;
    private List<Rental>rental;

    public Customer(String firstName, String lastName, String email, Boolean activebool, LocalDate createDate, LocalDate lastUpdate, Boolean active,
                    List<Payment> payment, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activebool = activebool;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.active = active;
        this.payment = payment;
        this.address = address;
    }
    public Customer(Customer customer,List<Rental>rental)
    {
        this.firstName = customer.firstName;
        this.lastName = customer.lastName;
        this.email = customer.email;
        this.activebool = customer.activebool;
        this.createDate = customer.createDate;
        this.lastUpdate = customer.lastUpdate;
        this.active = customer.active;
        this.payment = customer.payment;
        this.address = customer.address;
        this.rental=rental;
    }

}
