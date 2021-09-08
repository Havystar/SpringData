package pl.lbd.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class Staff {
    @Id
    private Long staffId;

    private Store store;
    private String firtName;
    private String lastName;
    private String email;
    private Boolean active;
    private String username;
    private String password;
    private LocalDate lastUpdate;
    private String picture;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Address address;


    public Staff(Store store, String firtName, String lastName, String email, Boolean active, String username, String password, LocalDate lastUpdate, String picture, Address address) {
        this.store = store;
        this.firtName = firtName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.picture = picture;
        this.address = address;
    }
}