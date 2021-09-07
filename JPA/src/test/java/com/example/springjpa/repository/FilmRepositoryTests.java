package com.example.springjpa.repository;


import com.example.springjpa.SpringJpaApplication;
import com.example.springjpa.entity.Film;
import com.example.springjpa.repository.FilmRepository;
import com.example.springjpa.repository.LanguageRepository;
import com.example.springjpa.service.FilmService;
import com.example.springjpa.utils.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = SpringJpaApplication.class)
public class FilmRepositoryTests {
    @Autowired
    FilmService filmService;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Test
    public void Check_findAllByLanguage() {

        Film film = new Film(LocalDate.now(), "test", "test", LocalDate.now(), 20
                , 20, 20, 20, Rating.G, "test", null, null, languageRepository.getById(1L), null);
        Film badFilm = new Film(LocalDate.now(), "test2", "test2", LocalDate.now(), 25
                , 25, 25, 25, Rating.G, "test2", null, null, languageRepository.getById(1L), null);
        filmRepository.save(film);
        assertEquals(filmRepository.findAllByLanguage("Polski").stream().
                filter(f -> f.getTitle().equals("test")).
                findFirst().get(), film);
        assertNotEquals(filmRepository.findAllByLanguage("Polski").stream().
                filter(f -> f.getTitle().equals("test")).
                findFirst().get(), badFilm);
    }

}
