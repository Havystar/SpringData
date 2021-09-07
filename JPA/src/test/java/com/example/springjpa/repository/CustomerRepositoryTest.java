package com.example.springjpa.repository;

import com.example.springjpa.SpringJpaApplication;
import com.example.springjpa.entity.Address;
import com.example.springjpa.entity.Customer;
import com.example.springjpa.querryResult.CustomerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = SpringJpaApplication.class)
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AddressRepository addressRepository;
    @Test
    public void shouldGetProperAddressAndCustomer()
    {
        //Given
        Customer customer=customerRepository.findById(1L).get();
        Address address = addressRepository.findById(1L).get();
        //Expected
        CustomerAddress customerAddress=customerRepository.getCustomerAndAddress(1L);
        //Result
        assertEquals(address,customerAddress.getAddress());
        assertEquals(customer,customerAddress.getCustomer());
    }
    @Test
    public void shouldntFindAddressAndCustomer()
    {
        //Given
        Customer customer=customerRepository.findById(1L).get();
        Address address = addressRepository.findById(1L).get();
        //Expected
        CustomerAddress customerAddress=customerRepository.getCustomerAndAddress(2L);
        //Result
        assertNotEquals(customer,customerAddress.getCustomer());
    }
    @Test
    public void shouldThrowExceptionAddressAndCustomer()
    {
        //Given
        Customer customer=customerRepository.findById(1L).get();
        Address address = addressRepository.findById(1L).get();
        //Expected
        CustomerAddress customerAddress=customerRepository.getCustomerAndAddress(10L);
        //Result
        assertThrows(NullPointerException.class,()->{throw new NullPointerException();});
    }


}