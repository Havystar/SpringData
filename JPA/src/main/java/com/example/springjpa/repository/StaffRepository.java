package com.example.springjpa.repository;

import com.example.springjpa.entity.Staff;
import com.example.springjpa.querryResult.StaffAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {

    @Query("select new com.example.springjpa.querryResult.StaffAddress(s,a) from Staff s join s.address a ")
    List<StaffAddress> listStaffAndAddress();
}
