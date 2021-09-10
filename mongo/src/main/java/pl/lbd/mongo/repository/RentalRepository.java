package pl.lbd.mongo.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Rental;

import java.util.List;

@Repository
public interface RentalRepository extends MongoRepository<Rental, String> {
    List<Rental> findAllByCustomer_FirstName(String name, Pageable pageable);
}
