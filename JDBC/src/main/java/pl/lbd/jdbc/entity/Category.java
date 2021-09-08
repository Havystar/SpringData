package pl.lbd.jdbc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    private long categoryId;
    private String name;
    private LocalDate lastUpdate;

    public Category(String name, LocalDate lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }
}