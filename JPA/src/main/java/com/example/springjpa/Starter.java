package com.example.springjpa;

import com.example.springjpa.entity.*;
import com.example.springjpa.repository.*;
import com.example.springjpa.utils.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

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
    addLanguages();
    addFilms();
    addCategory();
    }
    public void addLanguages()
    {
        languageRepository.save(new Language("Polski",LocalDate.now(),null));
        languageRepository.save(new Language("Angielski",LocalDate.now(),null));
        languageRepository.save(new Language("Niemiecki",LocalDate.now(),null));
    }
    public void addCategory()
    {
        Category category= new Category("Wielkie",LocalDate.now(),null);
        Category category2= new Category("Horror",LocalDate.now(),null);
        Category category3= new Category("Dramat",LocalDate.now(),null);
        categoryRepository.save(category);
        categoryRepository.save(category2);
        categoryRepository.save(category3);


    }
    public void addFilms()
    {
        Optional<Language> opLanguage=languageRepository.findById(1L);
       Film film= new Film(LocalDate.now(),"Kiepscy","XD",LocalDate.now(),20
               ,20,20,20,Rating.G,"XD",null,null,opLanguage.get());
        Film film1= new Film(LocalDate.now(),"Tytanic","XD",LocalDate.now(),20
                ,20,20,20,Rating.G,"XD",null,null,opLanguage.get());
        Film film2= new Film(LocalDate.now(),"Wielki Potwor","XD",LocalDate.now(),20
                ,20,20,20,Rating.G,"XD",null,null,opLanguage.get());
        filmRepository.save(film);
        filmRepository.save(film2);
        filmRepository.save(film1);



    }


}
