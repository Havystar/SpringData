package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Staff;

import java.util.List;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {

    public List<Staff> findAllByStore_Address_Address(String s);
}
