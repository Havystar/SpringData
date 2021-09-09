package pl.lbd.mongo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lbd.mongo.MongoApplication;
import pl.lbd.mongo.document.Film;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = MongoApplication.class)
class LanguageRepositoryTest {

    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    FilmRepository filmRepository;

    @Test
    public void shouldReturnRightFilm()
    {
       List<Film> movies =languageRepository.findByName("Polski").get().getFilms();
       Film film1= filmRepository.findFilmByTitle("title1").get();
       Film film2=filmRepository.findFilmByTitle("title2").get();
       List<Film>filmList = Arrays.asList(film1,film2);
       assertIterableEquals(movies,filmList);
    }

}