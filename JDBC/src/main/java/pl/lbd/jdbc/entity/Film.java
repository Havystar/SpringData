package pl.lbd.jdbc.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import pl.lbd.jdbc.enums.Rating;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
public class Film {
    @Id
    private long filmId;
    private String title;
    private String description;
    private LocalDate releaseYear;
    private int rentalDuration;
    private double rental_rate;
    private int length;
    private double replacement_cost;
    private Rating rating;
    private LocalDate lastUpdate;
    private String special_features;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Language language;


    public Film(String title, String description, LocalDate releaseYear, int rentalDuration, double rental_rate, int length, double replacement_cost, Rating rating, LocalDate lastUpdate, String special_features, Language language) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.lastUpdate = lastUpdate;
        this.special_features = special_features;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", rentalDuration=" + rentalDuration +
                ", rental_rate=" + rental_rate +
                ", length=" + length +
                ", replacement_cost=" + replacement_cost +
                ", rating=" + rating +
                ", lastUpdate=" + lastUpdate +
                ", special_features='" + special_features + '\'' +
                ", language=" + language +
                '}';
    }
}
