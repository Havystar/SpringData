package com.example.springjpa.repository;

import com.example.springjpa.entity.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Long> {

}
