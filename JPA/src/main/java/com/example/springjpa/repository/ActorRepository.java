package com.example.springjpa.repository;

import com.example.springjpa.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
    @Query("SELECT actor FROM Actor actor join actor.filmActors filmActors join filmActors.film film where film.title=?1")
    List<Actor> findAllByFilm(String searched);
}
