package pl.lbd.jdbc.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.jdbc.entity.Category;

import java.util.List;
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {


    @Query("select * from category order by name")
    List<Category> listAllSorted();

}
