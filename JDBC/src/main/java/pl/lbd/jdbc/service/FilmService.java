package pl.lbd.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lbd.jdbc.entity.Rental;
import pl.lbd.jdbc.repository.RentalRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    RentalRepository rentalRepository;

    public String getStatus(Long id) {
        LocalDate now = LocalDate.now();
        Optional<Rental> rental = rentalRepository.findByFilmId(id);
        if(rental.get()!=null&&rental.get().getReturnDate()!=null) {
            return "dostępny";
        }
        else {
            return "wypozyczony";
        }
    }
}
