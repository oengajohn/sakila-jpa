package io.github.oengajohn.sakilaappjpa.controller;

import io.github.oengajohn.sakilaappjpa.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaappjpa.controller.dto.LanguageDto;
import io.github.oengajohn.sakilaappjpa.service.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/language")
@RestController
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("list")
    public GenericResponse<List<LanguageDto>> list(){
        return GenericResponse.success(
                languageService.listLanguages()
        );
    }
    @PostMapping("saveOrUpdate")
    public GenericResponse<List<LanguageDto>> saveOrUpdate(@RequestBody List<LanguageDto> languageDtoList){
        return GenericResponse.success(
                languageService.saveOrUpdate(languageDtoList)
        );
    }
    @DeleteMapping("destroy")
    public GenericResponse<?> destroy(@RequestBody List<LanguageDto> languageDtoList){
        languageService.destroy(languageDtoList);

        return GenericResponse.success(
        );
    }
}
