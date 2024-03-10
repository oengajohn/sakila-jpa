package io.github.oengajohn.sakilaappjpa.controller;

import io.github.oengajohn.sakilaappjpa.controller.dto.FilmDto;
import io.github.oengajohn.sakilaappjpa.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaappjpa.service.FilmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/film")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }


    @GetMapping("list")
    public GenericResponse<List<FilmDto>> list(@RequestParam( value = "start", defaultValue = "0") int start,
                                               @RequestParam( value = "limit", defaultValue = "10") int limit
                                                ){
        var filmDtoPage= filmService.listFilms(start, limit);
        return GenericResponse.success(
                filmDtoPage.getContent(),
                filmDtoPage.getTotalElements()
        );
    }
    @GetMapping("searchFilms")
    public GenericResponse<List<FilmDto>> searchFilms(  @RequestParam( value = "start", defaultValue = "0") int start,
                                                          @RequestParam( value = "limit", defaultValue = "10") int limit,
                                                          @RequestParam( value = "query",required = false) String query){
        var filmDtoPage= filmService.searchFilms(start, limit,query);
        return GenericResponse.success(
                filmDtoPage.getContent(),
                filmDtoPage.getTotalElements()
        );
    }
}
