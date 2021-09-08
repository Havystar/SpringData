package pl.lbd.jdbc.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import pl.lbd.jdbc.entity.Category;

import java.util.List;

public interface CategoryRepository extends Repository<Category,Long> {


    @Query("select * from category order by name")
    List<Category> listAllSorted();
}
