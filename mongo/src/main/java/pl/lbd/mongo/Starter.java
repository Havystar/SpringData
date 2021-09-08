package pl.lbd.mongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.lbd.mongo.document.Actor;
import pl.lbd.mongo.repository.ActorRepository;

@SpringBootApplication
public class Starter implements CommandLineRunner {
    @Autowired
    ActorRepository actorRepository;
    public void run(String... args) throws Exception {
        System.out.println("sd");
        Actor actor1 = new Actor("Zenek", "Orda", null);
        actorRepository.insert(actor1);
    }
}
