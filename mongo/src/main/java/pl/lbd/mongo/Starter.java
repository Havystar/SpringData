package pl.lbd.mongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import pl.lbd.mongo.document.*;
import pl.lbd.mongo.repository.*;
import pl.lbd.mongo.service.FilmService;
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
    @Autowired
    FilmService filmService;

    public void run(String... args) throws Exception {
       // insertData();
        taskRunner();


    }

    public void taskRunner(){
        //task1
        List<Category> task1 = categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        //task2
        Pageable paging = PageRequest.of(0, 20);
        List<Film>task2=filmRepository.findFilmByCategories_name("Horror",paging);
        //task3
        List <Film> task3 = languageRepository.findByName("Polski").get().getFilms();
        //task4
        List <Film> task4 = actorRepository.findActorByFirstName("Zenek").get().getFilms();
        //Task5
        Boolean status= filmService.getStatus("title1");
        //task6
        List <Payment> task6 = customerRepository.findFirstByFirstName("Zenek3").get().getPayment();
        //task7
        Customer task7 = customerRepository.findFirstByFirstName("Zenek3").get();
        //task8 Lista pracownikow danego sklepu
        List <Staff> task8 = staffRepository.findAllByStore_Address_Address("Brzozowa");
        //task9
        List <Film> task9 = actorRepository.findActorByFirstNameAndLastName("Zenek","Orda").get().getFilms();
        //Task10
        Pageable paging2 = PageRequest.of(0, 20,Sort.by(Sort.Order.desc("rentalDate")));
        List<Rental>task10=rentalRepository.findAllByCustomer_FirstName("Zenek3",paging2);
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



        Actor actor1 = new Actor("Zenek", "Orda", null);
        Actor actor2 = new Actor("Kalif", "Ichdżba", null);
        Actor actor3 = new Actor("Enek", "Benek", null);
        // Actor actor1Full = new Actor("Zenek", "Orda", null);
        // actor1Full.setFilms(Arrays.asList(film1));


        Category category1 = new Category("Horror", now);
        Category category2 = new Category("Komedia", now);
        Category category3 = new Category("Nuda", now);

        Film film1 = new Film(now, "title1",  "description1",  now,10 ,10,
                10 ,10 , Rating.G, "ASDSD",Arrays.asList(category1),null);
        Film film2 = new Film(now, "title2",  "description2",  now,10 ,10 ,
                10 ,10 , Rating.G, "ASDSD",Arrays.asList(category2),null);
        Film film3 = new Film(now, "title3",  "description3",  now,10 ,10 ,
                10 ,10 , Rating.G, "ASDSD",Arrays.asList(category3),null);

        Language language1 = new Language("Polski", now, Arrays.asList(film1,film2));
        Language language2 = new Language("Angielski", now, Arrays.asList(film2,film3));
        Language language3 = new Language("Rosyjski", now, Arrays.asList(film1,film3));


        Staff staff1Empty = new Staff("Zenek1", "Ahmed1", "asd@wp.pl", true, "nickname", "123", now, "xD", address1);
        Staff staff2Empty = new Staff("Zenek2", "Ahmed2", "asd@wp.pl", true, "nickname", "123", now, "xD", address2);
        Staff staff3Empty = new Staff("Zenek3", "Ahmed3", "asd@wp.pl", true, "nickname", "123", now, "xD", address3);

        Store store1Empty = new Store(now, address1);
        Store store2Empty = new Store(now, address2);
        Store store3Empty = new Store(now, address3);

        Staff staff1= new Staff(staff1Empty,store1Empty);
        Staff staff2= new Staff(staff2Empty,store2Empty);
        Staff staff3= new Staff(staff3Empty,store3Empty);
        Store store1 = new Store(store1Empty,Arrays.asList(staff1));
        Store store2 = new Store(store2Empty,Arrays.asList(staff2));
        Store store3 = new Store(store3Empty,Arrays.asList(staff3));

        Payment payment1 = new Payment(20.2, now, staff1);
        Payment payment2 = new Payment(22.2, now, staff2);
        Payment payment3 = new Payment(24.2, now, staff3);
        Rental rental1Empty = new Rental(now,now, LocalDate.of(1999,12,12));
        Rental rental2Empty = new Rental(now,now,now);
        Rental rental3Empty = new Rental(now,now,LocalDate.of(2012,12,12));

        Inventory inventory1=new Inventory(store1,now,rental1Empty);
        Inventory inventory2=new Inventory(store2,now,rental2Empty);
        Inventory inventory3=new Inventory(store3,now,rental3Empty);
        film1.setInventories(Arrays.asList(inventory1));
        film2.setInventories(Arrays.asList(inventory2));
        film3.setInventories(Arrays.asList(inventory3));




        Customer customer1Empty = new Customer("Zenek1", "Ahmed3", "asd@wp.pl", true, now, now,
                true, Arrays.asList( payment1, payment3), address1);
        Customer customer2Empty = new Customer("Zenek2", "Ahmed3", "asd@wp.pl", true, now, now,
                true,  Arrays.asList( payment2, payment3), address1);
        Customer customer3Empty = new Customer("Zenek3", "Ahmed3", "asd@wp.pl", true, now, now,
                true,  Arrays.asList( payment1, payment3), address1);
        Rental rental1 = new Rental(rental1Empty,customer3Empty);
        Rental rental2 = new Rental(rental2Empty,customer2Empty);
        Rental rental3 = new Rental(rental3Empty,customer3Empty);
        Customer customer1 = new Customer(customer1Empty,Arrays.asList(rental1Empty));
        Customer customer2 = new Customer(customer2Empty,Arrays.asList(rental2Empty));
        Customer customer3 = new Customer(customer3Empty,Arrays.asList(rental3Empty,rental1Empty));

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

        rentalRepository.insert(rental1);
        rentalRepository.insert(rental2);
        rentalRepository.insert(rental3);

        inventoryRepository.insert(inventory1);
        inventoryRepository.insert(inventory2);
        inventoryRepository.insert(inventory3);

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
