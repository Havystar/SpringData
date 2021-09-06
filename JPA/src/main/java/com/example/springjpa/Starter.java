package com.example.springjpa;

import com.example.springjpa.entity.Customer;
import com.example.springjpa.entity.FilmCategory;
import com.example.springjpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Starter implements CommandLineRunner {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    FilmActorRepository filmActorRepository;
    @Autowired
    FilmCategoryRepository filmCategoryRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    RentalRepository repository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    StoreRepository storeRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
