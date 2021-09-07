package com.example.springjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;
    private LocalDateTime lastUpdate;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "city_id")
    private City city;
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private List<Customer> customers;
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
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

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", district='" + district + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(id, address1.id) && Objects.equals(address, address1.address) && Objects.equals(address2, address1.address2) && Objects.equals(district, address1.district) && Objects.equals(postalCode, address1.postalCode) && Objects.equals(phone, address1.phone) && Objects.equals(lastUpdate, address1.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, address2, district, postalCode, phone, lastUpdate);
    }
}
