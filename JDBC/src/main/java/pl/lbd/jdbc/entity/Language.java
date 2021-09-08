package pl.lbd.jdbc.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data

@NoArgsConstructor
public class Language {
    @Id
    private Long languageId;
    private String name;
    private LocalDate lastUpdate;
    private List<Film> film;

    public Language(String name, LocalDate lastUpdate, List<Film> film) {
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.film = film;
    }

}
