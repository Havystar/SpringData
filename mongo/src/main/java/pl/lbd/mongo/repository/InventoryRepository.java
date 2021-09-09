package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {
}
