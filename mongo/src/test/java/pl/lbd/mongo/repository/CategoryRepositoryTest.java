package pl.lbd.mongo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import pl.lbd.mongo.MongoApplication;
import pl.lbd.mongo.document.Film;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = MongoApplication.class)
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    FilmRepository filmRepository;
    @Test
    public void shouldGetRightMovies()
    {

       List<Film> filmList= filmRepository.findFilmByCategories_name("Horror", Pageable.unpaged());
       assertEquals(filmList.get(0),filmRepository.findFilmByTitle("title1").get());
    }

}