package pl.lbd.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class Store {

    @Id
    private Long storeId;
    private Staff managerStaffId;
    private Address address;
    private LocalDateTime lastUpadte;
    List<Customer> customers;
    List<Inventory>inventories;

    public Store(Staff managerStaffId, Address address, LocalDateTime lastUpadte, List<Customer> customers, List<Inventory> inventories) {
        this.managerStaffId = managerStaffId;
        this.address = address;
        this.lastUpadte = lastUpadte;
        this.customers = customers;
        this.inventories = inventories;
    }
}
