package pl.lbd.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class City {
    @Id
    private long cityId;
    private String city;
    LocalDateTime lastUpdate;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Country country;

    public City(String city, LocalDateTime lastUpdate, Country country) {
        this.city = city;
        this.lastUpdate = lastUpdate;
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
