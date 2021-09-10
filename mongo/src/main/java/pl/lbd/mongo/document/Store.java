package pl.lbd.mongo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document
@NoArgsConstructor
public class Store {

    @Id
    private String storeId;
    private LocalDate lastUpdate;
    private List<Staff> staffList;
    private Address address;

    public Store(LocalDate lastUpdate, Address address) {
        this.lastUpdate = lastUpdate;
        this.address = address;
    }
    public Store(Store store,List<Staff> staffList)
    {
        this.storeId=store.storeId;
        this.address=store.address;
        this.lastUpdate=store.lastUpdate;
        this.staffList=staffList;
    }
}
