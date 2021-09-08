package pl.lbd.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.lbd.jdbc.entity.Category;
import pl.lbd.jdbc.entity.Film;
import pl.lbd.jdbc.repository.ActorRepository;
import pl.lbd.jdbc.repository.CategoryRepository;
import pl.lbd.jdbc.repository.FilmRepository;

import java.util.List;

@SpringBootApplication
public class Starter implements CommandLineRunner {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    FilmRepository filmRepository;
    @Override
    public void run(String... args) throws Exception {
        //outputs for tasks
        //Task 1
        //List<Category> task1 = categoryRepository.listAllSorted();
        //Task 2
        Pageable paging = PageRequest.of(0, 20);
        List<Film> task2 = filmRepository.findAllByCategory("Horror",paging);
        task2.forEach(System.out::println);
        //Task 3
        //List<Film> task3 = filmRepository.findAllByLanguage("Polski");
        //Task 4
        actorRepository.getAllActorsInFilm("Kiepscy").forEach(System.out::println);
        //Task 9
        List<Film> task9 = filmRepository.findAllByActorNameAndLastName("Andrzej","Kabala");
        task9.forEach(System.out::println);
    }
}
