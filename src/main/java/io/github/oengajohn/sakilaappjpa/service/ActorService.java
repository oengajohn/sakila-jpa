package io.github.oengajohn.sakilaappjpa.service;

import io.github.oengajohn.sakilaappjpa.controller.dto.ActorDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActorService {
    List<ActorDto> saveOrUpdate(List<ActorDto> actorDtoList);

    List<ActorDto> listActors();

    Page<ActorDto> searchActors(int start, int limit, String query);

    List<ActorDto> findActorsByFilmId( int filmId);

    void destroy(List<ActorDto> actorDtoList);
}
