package pl.lbd.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class Country {

    @Id
    private long countryId;
    private String country;
    LocalDateTime lastUpdate;


    public Country(String country, LocalDateTime lastUpdate) {
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Country{" +
                ", country='" + country + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
