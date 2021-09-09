package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Store;

@Repository
public interface StoreRepository extends MongoRepository<Store, String> {
}
