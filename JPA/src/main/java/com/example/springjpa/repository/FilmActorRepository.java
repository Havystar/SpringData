package com.example.springjpa.repository;

import com.example.springjpa.entity.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmActorRepository extends JpaRepository<FilmActor,Long> {
}
