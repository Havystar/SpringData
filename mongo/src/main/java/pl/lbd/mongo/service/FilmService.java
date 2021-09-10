package pl.lbd.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lbd.mongo.document.Film;
import pl.lbd.mongo.document.Inventory;
import pl.lbd.mongo.document.Rental;
import pl.lbd.mongo.repository.FilmRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public Boolean getStatus(String name) {
       Optional<Film> optionalFilm= filmRepository.findFilmByTitle(name);
       Film film=optionalFilm.orElseThrow(()->new RuntimeException("Film doesn't exist"));
       List<Rental> rentalList =film.getInventories().stream().map(inventory -> inventory.getRental()).collect(Collectors.toList());
       if(rentalList.stream().anyMatch(rental -> rental.getReturnDate()!=null)||
               film.getInventories().stream().anyMatch(i->i.getRental()==null))
       {
           return true;
       }
       else
       {
           return false;
       }
    }

}
