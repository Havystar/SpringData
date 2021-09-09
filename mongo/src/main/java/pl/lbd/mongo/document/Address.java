package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
@NoArgsConstructor
public class Address {

    @Id
    private String id;
    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;
    private LocalDate lastUpdate;

    public Address(String address, String address2, String district, String postalCode, String phone, LocalDate lastUpdate) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
    }
}
