package pl.lbd.mongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.lbd.mongo.document.*;
import pl.lbd.mongo.repository.*;
import pl.lbd.mongo.utils.Rating;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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
       // insertData();
        taskRunner();


    }

    public void taskRunner(){
        //task1
        //List<Category> task1 = categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        //task2
        //List <Film> task2 = categoryRepository.findCategoryByName("Horror").get().getFilms();
        //task3
        //List <Film> task3 = languageRepository.findByName("Polski").get().getFilms();
        //task4
        //List <Film> task4 = actorRepository.findActorByFirstName("Zenek").get().getFilms();
        //task6
        //List <Payment> task6 = customerRepository.findCustomerByFirstName("Zenek3").get().getPayment();
        //task7
        //Customer task7 = customerRepository.findCustomerByFirstName("Zenek3").get();
        //task9
        //List <Film> task9 = actorRepository.findActorByFirstNameAndLastName("Zenek","Orda").get().getFilms();
    }


    public void insertData(){
        LocalDate now = LocalDate.now();

        City city1 = new City("Miasto1", now);
        City city2 = new City("Miasto2", now);
        City city3 = new City("Miasto3", now);

        Country country1 = new Country("Polska",now);
        Country country2 = new Country("Rosja",now);
        Country country3 = new Country("Ukraina",now);

        Address address1 = new Address("Brzozowa","KEK", "district1","44-100", "2234234534", now);
        Address address2 = new Address("Lipowa","KEKW", "district2","44-100", "2234234534", now);
        Address address3 = new Address("Sieprowa","KEKWWWW", "district3","44-100", "2234234534", now);

        Store store1 = new Store(now, address1);
        Store store2 = new Store(now, address2);
        Store store3 = new Store(now, address3);

        Actor actor1 = new Actor("Zenek", "Orda", null);
        Actor actor2 = new Actor("Kalif", "Ichdżba", null);
        Actor actor3 = new Actor("Enek", "Benek", null);
        // Actor actor1Full = new Actor("Zenek", "Orda", null);
        // actor1Full.setFilms(Arrays.asList(film1));
        Film film1 = new Film(now, "title1",  "description1",  now,10 ,10 ,10 ,10 , Rating.G, "ASDSD");
        Film film2 = new Film(now, "title2",  "description2",  now,10 ,10 ,10 ,10 , Rating.G, "ASDSD");
        Film film3 = new Film(now, "title3",  "description3",  now,10 ,10 ,10 ,10 , Rating.G, "ASDSD");

        Category category1 = new Category("Horror", now, Arrays.asList(film1));
        Category category2 = new Category("Komedia", now, Arrays.asList(film2));
        Category category3 = new Category("Nuda", now, Arrays.asList(film3));


        Language language1 = new Language("Polski", now, Arrays.asList(film1,film2));
        Language language2 = new Language("Angielski", now, Arrays.asList(film2,film3));
        Language language3 = new Language("Rosyjski", now, Arrays.asList(film1,film3));


        Staff staff1 = new Staff("Zenek1", "Ahmed1", "asd@wp.pl", true, "nickname", "123", now, "xD", address1, store1);
        Staff staff2 = new Staff("Zenek2", "Ahmed2", "asd@wp.pl", true, "nickname", "123", now, "xD", address2, store2);
        Staff staff3 = new Staff("Zenek3", "Ahmed3", "asd@wp.pl", true, "nickname", "123", now, "xD", address3, store3);

        Payment payment1 = new Payment(20.2, now, staff1);
        Payment payment2 = new Payment(22.2, now, staff2);
        Payment payment3 = new Payment(24.2, now, staff3);

        Customer customer1 = new Customer("Zenek1", "Ahmed3", "asd@wp.pl", true, now, now, true, Arrays.asList( payment1, payment3), address1);
        Customer customer2 = new Customer("Zenek2", "Ahmed3", "asd@wp.pl", true, now, now, true,  Arrays.asList( payment2, payment3), address1);
        Customer customer3 = new Customer("Zenek3", "Ahmed3", "asd@wp.pl", true, now, now, true,  Arrays.asList( payment1, payment3), address1);

        Film film1Full = new Film(film1, Arrays.asList(actor1));
        Film film2Full = new Film(film2, Arrays.asList(actor2));
        Film film3Full = new Film(film3, Arrays.asList(actor3));
        Actor actor1Full = new Actor(actor1, Arrays.asList(film1));
        Actor actor2Full = new Actor(actor2, Arrays.asList(film2));
        Actor actor3Full = new Actor(actor3, Arrays.asList(film3));

        customerRepository.insert(customer1);
        customerRepository.insert(customer2);
        customerRepository.insert(customer3);

        paymentRepository.insert(payment1);
        paymentRepository.insert(payment2);
        paymentRepository.insert(payment3);

        staffRepository.insert(staff1);
        staffRepository.insert(staff2);
        staffRepository.insert(staff3);

        countryRepository.insert(country1);
        countryRepository.insert(country2);
        countryRepository.insert(country3);

        cityRepository.insert(city1);
        cityRepository.insert(city2);
        cityRepository.insert(city3);

        storeRepository.insert(store1);
        storeRepository.insert(store2);
        storeRepository.insert(store3);

        addressRepository.insert(address1);
        addressRepository.insert(address2);
        addressRepository.insert(address3);

        actorRepository.insert(actor1Full);
        actorRepository.insert(actor2Full);
        actorRepository.insert(actor3Full);

        filmRepository.insert(film1Full);
        filmRepository.insert(film2Full);
        filmRepository.insert(film3Full);

        categoryRepository.insert(category1);
        categoryRepository.insert(category2);
        categoryRepository.insert(category3);

        languageRepository.insert(language1);
        languageRepository.insert(language2);
        languageRepository.insert(language3);
    }
}
