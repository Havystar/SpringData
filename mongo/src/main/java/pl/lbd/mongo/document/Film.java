package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.lbd.mongo.utils.Rating;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
@NoArgsConstructor
public class Film {
    @Id
    private String filmId;
    private LocalDate lastUpdate;
    private String title;
    private String description;
    private LocalDate releaseYear;
    private int rentalDuration;
    private double rental_rate;
    private int length;
    private double replacement_cost;
    private Rating rating;
    private String special_features;
    private List<Actor> actors;

    public Film(LocalDate lastUpdate, String title, String description, LocalDate releaseYear, int rentalDuration, double rental_rate, int length, double replacement_cost, Rating rating, String special_features) {
        this.lastUpdate = lastUpdate;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
    }

    public Film(LocalDate lastUpdate, String title, String description, LocalDate releaseYear, int rentalDuration, double rental_rate, int length, double replacement_cost, Rating rating, String special_features, List<Actor> actors) {
        this.lastUpdate = lastUpdate;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
        this.actors = actors;
    }

    public Film(Film film, List<Actor> actors) {
        this.lastUpdate = film.lastUpdate;
        this.title = film.title;
        this.description = film.description;
        this.releaseYear = film.releaseYear;
        this.rentalDuration = film.rentalDuration;
        this.rental_rate = film.rental_rate;
        this.length = film.length;
        this.replacement_cost = film.replacement_cost;
        this.rating = film.rating;
        this.special_features = film.special_features;
        this.actors = actors;
    }
}
