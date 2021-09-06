package com.example.springjpa.service;

import com.example.springjpa.entity.Film;
import com.example.springjpa.entity.Rental;
import com.example.springjpa.repository.FilmRepository;
import com.example.springjpa.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    RentalRepository repository;

    public String getStatus(Long id) {
        Rental rental = repository.findByFilmId(id);
        if(rental.getRentalDate() != null){
            return "wypożyczony";
        }
        else {
            return "dostępny";
        }
    }
}
