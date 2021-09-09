package pl.lbd.mongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.lbd.mongo.document.Actor;
import pl.lbd.mongo.document.Film;
import pl.lbd.mongo.repository.*;
import pl.lbd.mongo.utils.Rating;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
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
    FilmRepository filmRepository;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    StoreRepository storeRepository;

    public void run(String... args) throws Exception {
        LocalDate now = LocalDate.now();


        Actor actor1 = new Actor("Zenek", "Orda", now);
       // Actor actor1Full = new Actor("Zenek", "Orda", null);
       // actor1Full.setFilms(Arrays.asList(film1));
        Film film1 = new Film(now, "title1",  "description1",  now,10 ,10 ,10 ,10 , Rating.G, "ASDSD");
        Film film1Full = new Film(film1, Arrays.asList(actor1));
        Actor actor2Full = new Actor(actor1, Arrays.asList(film1));
        actorRepository.insert(actor2Full);
        filmRepository.insert(film1Full);


       // Actor actor2 = new Actor("Paweł", "Gaweł", null);
       // Film film2 = new Film(now, "title2",  "description2",  now,10 ,10 ,10 ,10 , Rating.G, "ASDSD", Arrays.asList(actor1,actor2));
       // actorRepository.insert(actor2);
       // filmRepository.insert(film2);
    }
}
