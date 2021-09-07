package com.example.springjpa.querryResult;

import com.example.springjpa.entity.Address;
import com.example.springjpa.entity.Staff;
import lombok.Data;

@Data
public class StaffAddress {
    Staff staff;
    Address address;

    public StaffAddress(Staff staff, Address address) {
        this.staff = staff;
        this.address = address;
    }
}
