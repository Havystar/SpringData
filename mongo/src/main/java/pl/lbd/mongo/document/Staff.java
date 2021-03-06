package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Document
@NoArgsConstructor
public class Staff {
    @Id
    private String staffId;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;
    private String username;
    private String password;
    private LocalDate lastUpdate;
    private String picture;
    private Address address;
    private Store store;



    public Staff(String firstName, String lastName, String email, Boolean active, String username, String password, LocalDate lastUpdate, String picture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.picture = picture;
    }
    public Staff(Staff staff,Store store)
    {
        this.firstName = staff.firstName;
        this.lastName = staff.lastName;
        this.email = staff.email;
        this.active = staff.active;
        this.username = staff.username;
        this.password = staff.password;
        this.lastUpdate = staff.lastUpdate;
        this.picture = staff.picture;
        this.store=store;
    }

    public Staff(String firstName, String lastName, String email, Boolean active, String username, String password, LocalDate lastUpdate, String picture, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.picture = picture;
        this.address = address;
        this.store = store;
    }

}
