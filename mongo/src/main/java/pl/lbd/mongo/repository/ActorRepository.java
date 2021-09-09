package pl.lbd.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.mongo.document.Actor;
import pl.lbd.mongo.document.Category;

import java.util.Optional;

@Repository
public interface ActorRepository extends MongoRepository<Actor, String> {
    Optional<Actor> findActorByFirstName(String firstName);
    Optional<Actor> findActorByFirstNameAndLastName(String firstName,String lastName);

}
