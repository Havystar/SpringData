package pl.lbd.jdbc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lbd.jdbc.entity.Language;
@Repository
public interface LanguageRepository extends CrudRepository<Language,Long> {

}
