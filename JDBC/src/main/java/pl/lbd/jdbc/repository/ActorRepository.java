package pl.lbd.jdbc.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lbd.jdbc.entity.Actor;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor,Long> {

    @Query("select * from actor a join film_actor fa on a.actor_id=fa.actor_id join film fi on fa.film_id=fi.film_id where fi.title=:name ")
    List<Actor> getAllActorsInFilm(@Param("name") String name);

}
