package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.City;

@Repository
public interface CityRepository extends MongoRepository<City, String> {
}
