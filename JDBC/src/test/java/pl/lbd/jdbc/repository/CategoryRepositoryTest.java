package pl.lbd.jdbc.repository;

import static org.junit.jupiter.api.Assertions.*;


import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lbd.jdbc.JdbcApplication;
import pl.lbd.jdbc.entity.Category;

import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@SpringBootTest(classes = JdbcApplication.class)
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    void findAllOrderByName() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        Collections.sort(categories, new Comparator<Category>() {
            @Override
            public int compare(Category c1, Category c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        assertIterableEquals(categoryRepository.listAllSorted().stream().map(Category::getName).collect(Collectors.toList()), categories.stream().map(Category::getName).collect(Collectors.toList()));
    }

}
