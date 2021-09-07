package com.example.springjpa.repository;

import com.example.springjpa.entity.Category;
import com.example.springjpa.entity.Customer;
import com.example.springjpa.entity.Payment;
import com.example.springjpa.entity.Rental;
import com.example.springjpa.querryResult.StaffAddress;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT c, a FROM Customer c join c.address a where c.customer_id=?1")
    List<Object[]> findDataAndAddressById(Long id);

    @Query("select l from Customer c join c.payments l where c.customer_id=?1")
    List<Payment> findCustomerPayments(Long id);

    @Query("select new com.example.springjpa.querryResult.CustomerAddress(c,a) from Customer c join c.address a where c.customer_id =?1")
    List<StaffAddress> listStaffAndAddress(Long id);
    @Query("select l from Rental l join l.customer c where c.customer_id=?1")
    List<Rental> findCustomerRentals(Long id, Pageable pageable);
}
