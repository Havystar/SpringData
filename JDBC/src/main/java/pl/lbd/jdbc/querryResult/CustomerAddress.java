package pl.lbd.jdbc.querryResult;


import lombok.Data;
import pl.lbd.jdbc.entity.Address;
import pl.lbd.jdbc.entity.Customer;

@Data
public class CustomerAddress {
    Customer customer;
    Address address;

    public CustomerAddress(Customer customer, Address address) {
        this.customer = customer;
        this.address = address;
    }

    public CustomerAddress() {
    }
}
