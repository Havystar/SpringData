package pl.lbd.jdbc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import pl.lbd.jdbc.entity.Inventory;

public interface InventoryRepository extends Repository<Inventory,Long> {
}
