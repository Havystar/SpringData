package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Actor;

@Repository
public interface ActorRepository extends MongoRepository<Actor, String> {
}
