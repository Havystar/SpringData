package com.example.springjpa.repository;

import com.example.springjpa.entity.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Long> {

}
