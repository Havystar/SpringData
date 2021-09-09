package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Staff;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {
}
