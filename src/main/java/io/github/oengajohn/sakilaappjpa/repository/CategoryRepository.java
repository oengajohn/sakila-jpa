package io.github.oengajohn.sakilaappjpa.repository;

import io.github.oengajohn.sakilaappjpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Short> {
    @Query("SELECT c FROM Category c INNER JOIN FilmCategory fc ON c.id = fc.category.id WHERE fc.film.id = :filmId")
    List<Category> findCategoriesByFilmId(@Param("filmId") int filmId);
}