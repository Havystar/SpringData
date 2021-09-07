package com.example.springjpa;


import com.example.springjpa.entity.Film;
import com.example.springjpa.repository.FilmRepository;
import com.example.springjpa.repository.LanguageRepository;
import com.example.springjpa.utils.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = SpringJpaApplication.class)
public class FilmRepositoryTests {
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Test
    public void Check_findAllByLanguage() {

        Film film = new Film(LocalDate.now(), "test", "test", LocalDate.now(), 20
                , 20, 20, 20, Rating.G, "test", null, null, languageRepository.getById(1L), null);
        filmRepository.save(film);
        assertEquals(filmRepository.findAllByLanguage("Polski").stream().
                filter(f -> f.getTitle().equals("test")).
                findFirst().get(), film);
    }
    


}
