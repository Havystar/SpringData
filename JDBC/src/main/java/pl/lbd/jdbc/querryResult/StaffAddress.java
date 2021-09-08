package pl.lbd.jdbc.querryResult;


import lombok.Data;
import lombok.NoArgsConstructor;
import pl.lbd.jdbc.entity.Address;
import pl.lbd.jdbc.entity.Staff;

@Data
@NoArgsConstructor
public class StaffAddress {
    Staff staff;
    Address address;

    public StaffAddress(Staff staff, Address address) {
        this.staff = staff;
        this.address = address;
    }
}
