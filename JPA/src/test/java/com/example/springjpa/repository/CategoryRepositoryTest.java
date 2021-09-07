package com.example.springjpa.repository;

import com.example.springjpa.SpringJpaApplication;
import com.example.springjpa.entity.Category;
import com.example.springjpa.entity.Film;
import com.example.springjpa.repository.FilmRepository;
import com.example.springjpa.repository.LanguageRepository;
import com.example.springjpa.service.FilmService;
import com.example.springjpa.utils.Rating;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@SpringBootTest(classes = SpringJpaApplication.class)
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    void findAllOrderByName() {
        List<Category> categories = categoryRepository.findAll();
        Collections.sort(categories, new Comparator<Category>() {
            @Override
            public int compare(Category c1, Category c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        assertIterableEquals(categoryRepository.findAllOrderByName().stream().map(Category::getName).collect(Collectors.toList()), categories.stream().map(Category::getName).collect(Collectors.toList()));
    }

}
