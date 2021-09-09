package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
