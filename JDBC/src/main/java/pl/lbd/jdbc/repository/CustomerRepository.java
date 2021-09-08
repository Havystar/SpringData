package pl.lbd.jdbc.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lbd.jdbc.entity.Payment;
import pl.lbd.jdbc.entity.Rental;

import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<CustomerRepository,Long> {


    @Query("select * from customer c join payment p on c.customer_id=p.customer_id where c.customer_id=:id")
    List<Payment> getAllPaymentsById(@Param("id")Long id);

    @Query("select * from rental r join customer c on r.customer_id=c.customer_id where c.customer_id=:id")
    List<Rental> getAllRentals(@Param("id")Long id, Pageable pageable);

}
