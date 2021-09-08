package com.example.springjpa.repository;

import com.example.springjpa.entity.Actor;
import com.example.springjpa.entity.Category;
import com.example.springjpa.entity.Film;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("select film from Film film join film.filmCategory filmCategory join filmCategory.category category WHERE category.name = ?1")
    List<Film> findAllByCategory(String searched, Pageable paging);
    @Query("select film from Film film join film.language language WHERE language.name = ?1")
    List<Film> findAllByLanguage(String searched);
    @Query("SELECT actor from Film film join film.filmActors filmActors JOIN filmActors.actor actor where actor.firstName=?1 and actor.lastName=?2")
    List<Actor> findAllByActorNameAndLastName(String firstName,String lastName);


}
