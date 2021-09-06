package com.example.springjpa.repository;

import com.example.springjpa.entity.Category;
import com.example.springjpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT c, a FROM Customer c join c.address a where c.customer_id=?1")
    List<Object[]> findDataAndAddressById(Long id);

}
