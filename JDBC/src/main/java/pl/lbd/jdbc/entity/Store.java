package pl.lbd.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class Store {

    @Id
    private Long storeId;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Staff managerStaffId;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Address address;
    private LocalDateTime lastUpadte;

    public Store(Staff managerStaffId, Address address, LocalDateTime lastUpadte) {
        this.managerStaffId = managerStaffId;
        this.address = address;
        this.lastUpadte = lastUpadte;
    }
}
