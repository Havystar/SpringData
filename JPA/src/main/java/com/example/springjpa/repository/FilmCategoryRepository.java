package com.example.springjpa.repository;

import com.example.springjpa.entity.FilmCategory;
import org.springframework.data.repository.CrudRepository;


public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Long> {

}
