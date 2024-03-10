package io.github.oengajohn.sakilaappjpa.service.impl;

import io.github.oengajohn.sakilaappjpa.component.DtoMapper;
import io.github.oengajohn.sakilaappjpa.controller.dto.ActorDto;
import io.github.oengajohn.sakilaappjpa.entity.Actor;
import io.github.oengajohn.sakilaappjpa.repository.ActorRepository;
import io.github.oengajohn.sakilaappjpa.service.ActorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDto> findActorsByFilmId(int filmId) {
        return actorRepository.findActorsByFilmId(filmId).stream().map(DtoMapper::mapToActorDto).toList();
    }


    @Override
    public List<ActorDto> saveOrUpdate(List<ActorDto> actorDtoList) {
        List<Actor> list = actorDtoList.stream().map(DtoMapper::mapToActorEntity).toList();
        return actorRepository.saveAll(list).stream().map(DtoMapper::mapToActorDto).toList();
    }

    @Override
    public void destroy(List<ActorDto> actorDtoList) {
        actorRepository.deleteAll(actorDtoList.stream().map(DtoMapper::mapToActorEntity).toList());
    }

    @Override
    public List<ActorDto> listActors() {
        return actorRepository.findAll().stream().map(DtoMapper::mapToActorDto).toList();
    }

    @Override
    public Page<ActorDto> searchActors(int start, int limit, String query) {
        Pageable paging = PageRequest.of(start, limit);
        Page<Actor> page;
        if (query != null) {
            page = actorRepository.findByFirstNameContainingOrLastNameContainingIgnoreCase(query, query, paging);
        } else {
            page = actorRepository.findAll(paging);
        }

        return new PageImpl<>(
                page.getContent().stream().map(DtoMapper::mapToActorDto).toList(),
                page.getPageable(),
                page.getTotalElements()
        );
    }

}
