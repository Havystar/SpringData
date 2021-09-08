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
    private Rental rental;
    private Store store;

    private Address address;

    @MappedCollection(idColumn = "customer_id")
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    List<Payment> payments;

    public Customer(String firstName, String lastName, String email, Boolean activebool,
                    LocalDateTime createDate, LocalDateTime lastUpdate, Boolean active, Rental rental,
                    Store store, Address address,List<Payment> payments) {
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
        this.payments=payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customer_id, customer.customer_id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(activebool, customer.activebool) && Objects.equals(createDate, customer.createDate) && Objects.equals(lastUpdate, customer.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, firstName, lastName, email, activebool, createDate, lastUpdate);
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", payments=" + payments +
                '}';
    }
}
