package io.github.oengajohn.sakilaappjpa.repository;


import io.github.oengajohn.sakilaappjpa.entity.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository  extends JpaRepository<Actor,Integer> {
    Page<Actor> findByFirstNameContainingOrLastNameContainingIgnoreCase(String firstName, String lastName, Pageable pageable);
    @Query("SELECT a FROM Actor a INNER JOIN FilmActor fa ON a.id = fa.actor.id WHERE fa.film.id = :filmId")
    List<Actor> findActorsByFilmId(@Param("filmId") int filmId);
}
