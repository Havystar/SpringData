package com.example.springjpa;

import com.example.springjpa.embedableKey.FilmCategoryKey;
import com.example.springjpa.entity.*;
import com.example.springjpa.repository.*;
import com.example.springjpa.utils.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

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

    @Override
    public void run(String... args) throws Exception {
        addLanguages();
        addFilms();
        addCategory();
        addFilmCategory();

        //outputs for tasks
        //task1
        categoryRepository.findAllOrderByName().stream().forEach(s -> System.out.println(s.getName()));
        //task2
        filmRepository.findAllByCategory("Horror").stream().forEach(s -> System.out.println(s.getFilmId()));
        //task3
        filmRepository.findAllByLanguage("Polski").stream().forEach(s -> System.out.println(s.getFilmId()));
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


//    public void connectFilmToCategory() {
//        Optional<Film> film = filmRepository.findById(1L);
//        Optional<Category> category = categoryRepository.findById(1L);
//        Set<FilmCategory> filmCategories = category.get().getFilmCategory();
//        film.get().setFilmCategory(filmCategories);
//        filmRepository.save(film.get());
//    }

}
