package pl.lbd.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lbd.mongo.document.Film;
import pl.lbd.mongo.document.Rental;
import pl.lbd.mongo.repository.FilmRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public String getStatus(String name) {
       Optional<Film> optionalFilm= filmRepository.findFilmByTitle(name);
       Film film=optionalFilm.orElseThrow(()->new RuntimeException("Nie ma takiego filmu!"));
       List<Rental> rentalList =film.getInventories().stream().map(inventory -> inventory.getRental()).collect(Collectors.toList());
       if(rentalList.stream().anyMatch(rental -> rental.getReturnDate()!=null))
       {
           return "Dostepny";
       }
       else
       {
           return "Brak";
       }
    }

}
