package com.example.springjpa.service;

import com.example.springjpa.entity.Film;
import com.example.springjpa.entity.Rental;
import com.example.springjpa.repository.FilmRepository;
import com.example.springjpa.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    RentalRepository repository;

    public String getStatus(Long id) {
        LocalDate now = LocalDate.now();
        Optional<Rental> rental = repository.findByFilmId(id);
        if(rental.get()!=null&&rental.get().getReturnDate()!=null) {
            if (now.isAfter(rental.get().getReturnDate())) {
                return "dostępny";
            }
        }
        return "wypozyczony";
    }
}
