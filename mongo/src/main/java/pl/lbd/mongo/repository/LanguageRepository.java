package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Category;
import pl.lbd.mongo.document.Language;

import java.util.Optional;

@Repository
public interface LanguageRepository extends MongoRepository<Language, String> {
    Optional<Language> findByName(String name);

}
