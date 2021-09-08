package pl.lbd.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class Customer {
    @Id
    private Long customer_id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean activebool;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private Boolean active;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Rental rental;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Store store;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Address address;


    public Customer(String firstName, String lastName, String email, Boolean activebool, LocalDateTime createDate, LocalDateTime lastUpdate, Boolean active, Rental rental, Store store, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activebool = activebool;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.active = active;
        this.rental = rental;
        this.store = store;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
