package pl.lbd.mongo.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Film;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
    Optional<Film> findFilmByTitle(String string);
    List<Film> findFilmByCategories_name(String s, Pageable pageable);
}
