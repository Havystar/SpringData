package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
}
