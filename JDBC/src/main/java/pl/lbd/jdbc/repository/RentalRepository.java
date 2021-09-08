package pl.lbd.jdbc.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.lbd.jdbc.entity.Rental;

import java.util.Optional;
@Repository
public interface RentalRepository extends CrudRepository<Rental,Long> {
    @Query("select * from rental r join inventory inv ON inv.inventory_id=r.inventory_id join film f ON f.film_id=inv.film_id where f.film_id =:id")
    Optional<Rental> findByFilmId(@Param("id") Long id);
}
