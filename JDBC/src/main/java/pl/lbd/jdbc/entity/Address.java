package pl.lbd.jdbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Address {

    @Id
    private Long addressId;
    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;
    private LocalDateTime lastUpdate;
    private City city;
    private List<Customer> customers;
    private List<Staff> staffList;
    public Address(String address, String address2, String district, String postalCode, String phone, LocalDateTime lastUpdate, City city, List<Customer> customers, List<Staff> staffList) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
        this.city = city;
        this.customers = customers;
        this.staffList = staffList;
    }
}
