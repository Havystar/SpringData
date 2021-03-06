package com.example.springjpa.querryResult;


import com.example.springjpa.entity.Address;
import com.example.springjpa.entity.Staff;
import lombok.Data;
import lombok.NoArgsConstructor;


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
