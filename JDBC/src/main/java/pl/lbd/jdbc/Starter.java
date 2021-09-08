package pl.lbd.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.lbd.jdbc.repository.ActorRepository;

@SpringBootApplication
public class Starter implements CommandLineRunner {
    @Autowired
    ActorRepository actorRepository;
    @Override
    public void run(String... args) throws Exception {
        actorRepository.findAll().forEach(System.out::println);
    }
}
