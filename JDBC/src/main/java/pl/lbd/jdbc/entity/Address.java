package pl.lbd.jdbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

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

    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private City city;

    public Address(String address, String address2, String district, String postalCode, String phone, LocalDateTime lastUpdate, City city) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
        this.city = city;
    }

    public Address() {

    }
}
