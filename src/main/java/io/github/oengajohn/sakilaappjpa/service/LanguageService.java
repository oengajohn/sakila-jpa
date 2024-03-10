package io.github.oengajohn.sakilaappjpa.service;

import io.github.oengajohn.sakilaappjpa.controller.dto.LanguageDto;

import java.util.List;

public interface LanguageService {
    List<LanguageDto> listLanguages();

    List<LanguageDto> saveOrUpdate(List<LanguageDto> languageDtoList);

    void destroy(List<LanguageDto> languageDtoList);
}
