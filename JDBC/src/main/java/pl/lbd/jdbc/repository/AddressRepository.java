package pl.lbd.jdbc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import pl.lbd.jdbc.entity.Address;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
