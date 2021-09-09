package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Country;

@Repository
public interface CountryRepository extends MongoRepository<Country, String> {
}
