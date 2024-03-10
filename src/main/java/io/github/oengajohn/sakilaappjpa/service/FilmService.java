package io.github.oengajohn.sakilaappjpa.service;

import io.github.oengajohn.sakilaappjpa.controller.dto.FilmDto;
import org.springframework.data.domain.Page;

public interface FilmService {
    Page<FilmDto>  listFilms(int start, int limit);

    Page<FilmDto> searchFilms(int start, int limit, String query);
}
