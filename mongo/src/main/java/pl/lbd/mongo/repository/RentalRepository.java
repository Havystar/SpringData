package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Rental;

@Repository
public interface RentalRepository extends MongoRepository<Rental, String> {
}
