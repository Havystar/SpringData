package com.example.springjpa.repository;

import com.example.springjpa.entity.Film;
import com.example.springjpa.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Long> {
    @Query("select rental from Rental rental join rental.inventory inv join inv.film film where film.filmId = ?1")
    Rental findByFilmId(Long id);

}
