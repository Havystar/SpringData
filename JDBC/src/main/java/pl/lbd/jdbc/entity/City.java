package pl.lbd.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class City {
    @Id
    private long cityId;
    private String city;
    LocalDateTime lastUpdate;

    private List<Address> addressList;

    private Country country;

    public City(String city, LocalDateTime lastUpdate, List<Address> addressList, Country country) {
        this.city = city;
        this.lastUpdate = lastUpdate;
        this.addressList = addressList;
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +

                ", city='" + city + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
