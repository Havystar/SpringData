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


    public Language(String name, LocalDate lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

}
