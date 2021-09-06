package com.example.springjpa.repository;

import com.example.springjpa.entity.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor,Long> {
}
