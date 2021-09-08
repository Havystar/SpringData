package pl.lbd.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.lbd.jdbc.entity.Category;
import pl.lbd.jdbc.repository.ActorRepository;
import pl.lbd.jdbc.repository.CategoryRepository;

import java.util.List;

@SpringBootApplication
public class Starter implements CommandLineRunner {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public void run(String... args) throws Exception {
        //outputs for tasks
        //Task 1
        List<Category> task1 = categoryRepository.listAllSorted();
    }
}
