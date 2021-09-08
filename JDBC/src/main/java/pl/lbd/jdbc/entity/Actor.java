package pl.lbd.jdbc.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Actor {
    @Id
    private Long actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;
}
