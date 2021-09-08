package pl.lbd.jdbc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import pl.lbd.jdbc.entity.Payment;

public interface PaymentRepository extends Repository<Payment,Long> {
}
