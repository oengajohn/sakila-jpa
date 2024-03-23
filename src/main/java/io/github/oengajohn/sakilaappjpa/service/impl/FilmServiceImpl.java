package io.github.oengajohn.sakilaappjpa.service.impl;

import io.github.oengajohn.sakilaappjpa.component.DtoMapper;
import io.github.oengajohn.sakilaappjpa.controller.dto.FilmDto;
import io.github.oengajohn.sakilaappjpa.entity.Film;
import io.github.oengajohn.sakilaappjpa.repository.FilmRepository;
import io.github.oengajohn.sakilaappjpa.service.ActorService;
import io.github.oengajohn.sakilaappjpa.service.CategoryService;
import io.github.oengajohn.sakilaappjpa.service.FilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    private final CategoryService categoryService;
    private final ActorService actorService;

    public FilmServiceImpl(FilmRepository filmRepository, CategoryService categoryService, ActorService actorService) {
        this.filmRepository = filmRepository;
        this.categoryService = categoryService;
        this.actorService = actorService;
    }

    @Override
    public Page<FilmDto> listFilms(int start, int limit) {
        Pageable paging = PageRequest.of(start, limit);
        Page<Film> page = filmRepository.findAll(paging);

        return new PageImpl<>(
                page.getContent().stream()
                        .map(DtoMapper::mapToFilmDto)
                        .peek(filmDto -> {
                            filmDto.setCategories(categoryService.findCategoriesByFilmId(filmDto.getFilmId()));
                            filmDto.setActors(actorService.findActorsByFilmId(filmDto.getFilmId()));
                        })
                        .collect(Collectors.toList()),
                page.getPageable(),
                page.getTotalElements()
        );

    }

    

    @Override
    public Page<FilmDto> searchFilms(int start, int limit, String query) {
        Pageable paging = PageRequest.of(start, limit);
        Page<Film> page;
        if (query != null) {
            page = filmRepository.findByTitleContainingIgnoreCase(query, paging);
        } else {
            page = filmRepository.findAll(paging);
        }

        return new PageImpl<>(
                page.getContent().stream()
                        .map(DtoMapper::mapToFilmDto)
                        .peek(filmDto -> {
                            filmDto.setCategories(categoryService.findCategoriesByFilmId(filmDto.getFilmId()));
                            filmDto.setActors(actorService.findActorsByFilmId(filmDto.getFilmId()));
                        })
                        .collect(Collectors.toList()),
                page.getPageable(),
                page.getTotalElements()
        );
    }
}
