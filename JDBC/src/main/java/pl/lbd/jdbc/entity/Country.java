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


    private List<City> cities;

    public Country(String country, LocalDateTime lastUpdate, List<City> cities) {
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.cities = cities;
    }


    @Override
    public String toString() {
        return "Country{" +
                ", country='" + country + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
