package pl.lbd.jdbc.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lbd.jdbc.JdbcApplication;
import pl.lbd.jdbc.entity.Film;
import pl.lbd.jdbc.entity.Language;
import pl.lbd.jdbc.enums.Rating;
import pl.lbd.jdbc.service.FilmService;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = JdbcApplication.class)
class FilmRepositoryTests {

    @Autowired
    FilmService filmService;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Test
    public void Check_findAllByLanguage() {

        assertEquals(filmRepository.findAllByLanguage("Polski").stream().
                filter(f -> f.getTitle().equals("Kiepscy")).
                findFirst().get().getFilmId(), 1);
    }

    @Test
    void findAllByActorNameAndLastName() {
        Film film2 = filmRepository.findAllByActorNameAndLastName("Andrzej" , "Kabala").get(0);
        assertEquals(film2.getTitle(), "Wielki Potwor");
    }
}