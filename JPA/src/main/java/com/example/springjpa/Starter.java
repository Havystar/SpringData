package com.example.springjpa;

import com.example.springjpa.embedableKey.FilmCategoryKey;
import com.example.springjpa.entity.*;
import com.example.springjpa.repository.*;
import com.example.springjpa.service.FilmService;
import com.example.springjpa.utils.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

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
    @Autowired
    FilmService filmService;
    @Autowired
    RentalRepository rentalRepository;


    @Override
    public void run(String... args) throws Exception {
        addLanguages();
        addFilms();
        addCategory();
        addFilmCategory();
        createActor();
        createFilmActor();
        addCountries();
        addCities();
        addAddress();
        addStaff();
        addStore();
        addCustomer();
        addInventory();
        addRental();
        addPayment();

        Country country=countryRepository.findById(1L).get();
        System.out.println(country.getCities().size());
        //outputs for tasks
        //task1
       // categoryRepository.findAllOrderByName().stream().forEach(s -> System.out.println(s.getName()));
        //task2
        //filmRepository.findAllByCategory("Horror").stream().forEach(s -> System.out.println(s.getDescription()));
        //task3
     //   filmRepository.findAllByLanguage("Polski").stream().forEach(s -> System.out.println(s.getFilmId()));
        //task4
        //actorRepository.findAllByFilm("Tytanic").stream().forEach(s -> System.out.println(s.getActorId()));
        //task5
        //filmService.getStatus(1L);
        //task7
        //customerRepository.findDataAndAddressById(1L);
        //task9
        //filmRepository.findAllByActorNameAndLastName("imie", "nazwisko").stream().forEach(s -> System.out.println(s.getActorId()));
    }

    public void addLanguages() {
        languageRepository.save(new Language("Polski", LocalDate.now(), null));
        languageRepository.save(new Language("Angielski", LocalDate.now(), null));
        languageRepository.save(new Language("Niemiecki", LocalDate.now(), null));
    }

    public void addCategory() {
        Category category = new Category("Wielkie", LocalDate.now(), null);
        Category category2 = new Category("Horror", LocalDate.now(), null);
        Category category3 = new Category("Dramat", LocalDate.now(), null);
        categoryRepository.save(category);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
    }

    public void addFilms() {
        Optional<Language> opLanguage = languageRepository.findById(1L);
        Film film = new Film(LocalDate.now(), "Kiepscy", "XD", LocalDate.now(), 20
                , 20, 20, 20, Rating.G, "XD", null, null, opLanguage.get(), null);
        Film film1 = new Film(LocalDate.now(), "Tytanic", "XD", LocalDate.now(), 20
                , 20, 20, 20, Rating.G, "XD", null, null, opLanguage.get(), null);
        Film film2 = new Film(LocalDate.now(), "Wielki Potwor", "XD", LocalDate.now(), 20
                , 20, 20, 20, Rating.G, "XD", null, null, opLanguage.get(), null);
        opLanguage.get().getFilm().add(film1);
        opLanguage.get().getFilm().add(film2);
        opLanguage.get().getFilm().add(film);
        languageRepository.save(opLanguage.get());
        filmRepository.save(film);
        filmRepository.save(film2);
        filmRepository.save(film1);
    }


    public void addFilmCategory() {
        Optional<Film> film = filmRepository.findById(1L);
        Optional<Category> category = categoryRepository.findById(1L);
        FilmCategory filmCategory = new FilmCategory(film.get(),category.get(),null);
        filmCategory.setId();
        film = filmRepository.findById(2L);
        category = categoryRepository.findById(2L);
        FilmCategory filmCategory2 = new FilmCategory(film.get(),category.get(),null);
        filmCategory2.setId();
        film = filmRepository.findById(3L);
        category = categoryRepository.findById(3L);
        FilmCategory filmCategory3 = new FilmCategory(film.get(),category.get(),null);
        filmCategory3.setId();
        filmCategoryRepository.save(filmCategory);
        filmCategoryRepository.save(filmCategory2);
        filmCategoryRepository.save(filmCategory3);
    }

    public void createActor()
    {
        Actor actor = new Actor("Andrzej","Kabala",null,null);
        Actor actor1 = new Actor("Jerzy","ASDASDAS",null,null);
        Actor actor2 = new Actor("Piotrek","ESESESE",null,null);
        actorRepository.saveAll(Arrays.asList(actor1,actor,actor2));
    }

    @Transactional
    public void createFilmActor()
    {
       Optional<Film> film= filmRepository.findById(1L);
       Optional<Film> film1=filmRepository.findById(2L);
       Optional<Film>film2=filmRepository.findById(3L);
       Optional<Actor> actor=actorRepository.findById(1L);
        FilmActor filmActor= new FilmActor(film.get(),actor.get(),null);
        FilmActor filmActor1= new FilmActor(film1.get(),actor.get(),null);
        FilmActor filmActor2= new FilmActor(film2.get(),actor.get(),null);
        filmActor.setId();
        filmActor1.setId();
        filmActor2.setId();
        filmActorRepository.saveAll(Arrays.asList(filmActor,filmActor1,filmActor2));
    }

    public void addCountries()
    {
        Country country= new Country("Serbia",null,null);
        Country country1= new Country("Bosnia",null,null);
        Country country2= new Country("Czechy",null,null);
        countryRepository.saveAll(Arrays.asList(country,country1,country2));
    }

    public void addCities()
    {
        City city=new City("Gliwice",null,null,countryRepository.findById(1L).get());
        City city1=new City("Zabrze",null,null,countryRepository.findById(1L).get());
        City city2=new City("Katowice",null,null,countryRepository.findById(3L).get());
        cityRepository.saveAll(Arrays.asList(city,city1,city2));
    }
    public void addAddress()
    {
     Address address = new Address("Zeromskiego","test","dystryk9","444-4","12341234",
             null,cityRepository.findById(1L).get(),null,null);
        Address address1 = new Address("Bytomska","test","dystryk1","444-4","12341234",
                null,cityRepository.findById(1L).get(),null,null);
        Address address2 = new Address("Katowicka","test","dystryk2","444-4","12341234",
                null,cityRepository.findById(1L).get(),null,null);
        addressRepository.saveAll(Arrays.asList(address,address1,address2));
    }


//    public void connectFilmToCategory() {
//        Optional<Film> film = filmRepository.findById(1L);
//        Optional<Category> category = categoryRepository.findById(1L);
//        Set<FilmCategory> filmCategories = category.get().getFilmCategory();
//        film.get().setFilmCategory(filmCategories);
//        filmRepository.save(film.get());
//    }

    public void addStaff()
    {
        Staff staff= new Staff(null,"Tomek","Tomek","EASDAS@gmail.com",
                null,"esses","es",null,"easdasd",addressRepository.findById(1L).get()
                ,null,null);
        Staff staff2= new Staff(null,"jerzy","Kicha","EASDAS@gmail.com",
                null,"esses","es",null,"easdasd",addressRepository.findById(1L).get()
                ,null,null);
        Staff staff3= new Staff(null,"Puotrek","Wojt","EASDAS@gmail.com",
                null,"esses","es",null,"easdasd",addressRepository.findById(1L).get()
                ,null,null);
        staffRepository.saveAll(Arrays.asList(staff,staff2,staff3));
    }

    public void addStore()
    {
        Store store = new Store(staffRepository.findById(1L).get(),addressRepository.findById(1L).get()
                ,null,null,null);
        Store store1 = new Store(staffRepository.findById(2L).get(),addressRepository.findById(1L).get()
                ,null,null,null);
        Store store2 = new Store(staffRepository.findById(3L).get(),addressRepository.findById(2L).get()
                ,null,null,null);
        storeRepository.saveAll(Arrays.asList(store,store2,store1));
    }


    public void addCustomer()
    {
        Customer customer = new Customer("Jerzy","Kabala","ASDASDASD@Gmail.com",null
                ,null,null,null,null
                ,storeRepository.findById(1L).get(),addressRepository.findById(1L).get());
        Customer customer1 = new Customer("Tomek","EASDAS","ASDASDASD@Gmail.com",null
                ,null,null,null,null
                ,storeRepository.findById(1L).get(),addressRepository.findById(1L).get());
        Customer customer2 = new Customer("Piotrek","Tomla","ASDASDASD@Gmail.com",null
                ,null,null,null,null
                ,storeRepository.findById(1L).get(),addressRepository.findById(3L).get());
        customerRepository.saveAll(Arrays.asList(customer,customer1,customer2));
    }

    public void addInventory()
    {
        Inventory inventory = new Inventory(null,null,storeRepository.findById(1L).get()
                ,filmRepository.findById(1L).get(),null);
        Inventory inventory1 = new Inventory(null,null,storeRepository.findById(2L).get()
                ,filmRepository.findById(1L).get(),null);
        Inventory inventory2 = new Inventory(null,null,storeRepository.findById(3L).get()
                ,filmRepository.findById(2L).get(),null);
        inventoryRepository.saveAll(Arrays.asList(inventory,inventory1,inventory2));
    }
    public void addRental()
    {
     Rental rental= new Rental(null,null,null,customerRepository.findById(2L).get()
     ,inventoryRepository.findById(1L).get(),staffRepository.findById(1L).get(),null);
     Rental rental1= new Rental(null,null,null,customerRepository.findById(2L).get()
                ,inventoryRepository.findById(1L).get(),staffRepository.findById(1L).get(),null);
     Rental rental2= new Rental(null,null,null,customerRepository.findById(3L).get()
                ,inventoryRepository.findById(3L).get(),staffRepository.findById(2L).get(),null);
     rentalRepository.saveAll(Arrays.asList(rental,rental1,rental2));

    }
    public void addPayment()
    {
        Payment payment= new Payment(205.15,null,customerRepository.findById(1L).get()
        ,staffRepository.findById(1L).get(),rentalRepository.findById(1L).get());
        Payment payment1= new Payment(21.15,null,customerRepository.findById(1L).get()
                ,staffRepository.findById(2L).get(),rentalRepository.findById(2L).get());
        Payment payment2= new Payment(19.15,null,customerRepository.findById(2L).get()
                ,staffRepository.findById(3L).get(),rentalRepository.findById(3L).get());
        paymentRepository.saveAll(Arrays.asList(payment,payment1,payment2));
    }
}
