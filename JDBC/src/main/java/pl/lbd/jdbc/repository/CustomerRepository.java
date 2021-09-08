package pl.lbd.jdbc.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lbd.jdbc.entity.Payment;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerRepository,Long> {


    @Query("select * from customer c join payment p on c.customer_id=p.customer_id where c.customer_id=:id")
    List<Payment> getAllPaymentsById(@Param("id")Long id);

}
