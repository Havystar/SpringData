package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Film;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
}
