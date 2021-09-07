package com.example.springjpa.querryResult;

import com.example.springjpa.entity.Address;
import com.example.springjpa.entity.Customer;
import lombok.Data;

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
