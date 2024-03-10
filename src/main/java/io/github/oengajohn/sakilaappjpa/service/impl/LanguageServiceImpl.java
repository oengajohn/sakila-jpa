package io.github.oengajohn.sakilaappjpa.service.impl;

import io.github.oengajohn.sakilaappjpa.component.DtoMapper;
import io.github.oengajohn.sakilaappjpa.controller.dto.LanguageDto;
import io.github.oengajohn.sakilaappjpa.entity.Language;
import io.github.oengajohn.sakilaappjpa.repository.LanguageRepository;
import io.github.oengajohn.sakilaappjpa.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<LanguageDto> saveOrUpdate(List<LanguageDto> languageDtoList) {
        List<Language> list = languageDtoList.stream().map(DtoMapper::mapToLanguageEntity).toList();
        return languageRepository.saveAll(list).stream().map(DtoMapper::mapToLanguageDto).toList();

    }

    @Override
    public void destroy(List<LanguageDto> languageDtoList) {
        languageRepository.deleteAll(languageDtoList.stream().map(DtoMapper::mapToLanguageEntity).toList());

    }

    @Override
    public List<LanguageDto> listLanguages() {
        return languageRepository.findAll().stream().map(DtoMapper::mapToLanguageDto).toList();

    }

}
