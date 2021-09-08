package pl.lbd.jdbc.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lbd.jdbc.entity.Actor;
import pl.lbd.jdbc.entity.Film;
import java.util.List;

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film,Long> {
    @Query("select * from film f join film_category fc on fc.film_id=f.film_id join category c on fc.category_id=c.category_id WHERE c.name =:category")
    List<Film> findAllByCategory(@Param("category") String category, Pageable paging);

    @Query("select * from film f join language l ON f.language_id=l.language_id WHERE l.name =:language")
    List<Film> findAllByLanguage(@Param("language") String language);

    @Query("SELECT * from film f join film_actor fa ON fa.film_id=f.film_id JOIN actor a ON a.actor_id=fa.actor_id where a.first_name=:firstName and a.last_name=:lastName")
    List<Film> findAllByActorNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName );
}
