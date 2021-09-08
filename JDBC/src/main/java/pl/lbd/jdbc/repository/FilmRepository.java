package pl.lbd.jdbc.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lbd.jdbc.entity.Film;
import java.util.List;

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film,Long> {
  //  @Query("select * from Film film join film.filmCategory filmCategory join filmCategory.category category WHERE category.name = ?1")
   // List<Film> findAllByCategory(String searched, Pageable paging);

    @Query("select * from film f join language l ON f.language_id=l.language_id WHERE l.name =:language")
    List<Film> findAllByLanguage(@Param("language") String language);
   // @Query("SELECT film from Film film join film.filmActors filmActors JOIN filmActors.actor actor where actor.firstName=?1 and actor.lastName=?2")
    //List<Actor> findAllByActorNameAndLastName(String firstName,String lastName);
}
