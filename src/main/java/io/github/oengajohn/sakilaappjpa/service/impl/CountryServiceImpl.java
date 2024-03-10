package io.github.oengajohn.sakilaappjpa.service.impl;

import io.github.oengajohn.sakilaappjpa.component.DtoMapper;
import io.github.oengajohn.sakilaappjpa.controller.dto.CountryDto;
import io.github.oengajohn.sakilaappjpa.entity.Country;
import io.github.oengajohn.sakilaappjpa.repository.CountryRepository;
import io.github.oengajohn.sakilaappjpa.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryDto> saveOrUpdate(List<CountryDto> countryDtoList) {
        List<Country> list = countryDtoList.stream().map(DtoMapper::mapToCountryEntity).toList();
        return countryRepository.saveAll(list).stream().map(DtoMapper::mapToCountryDto).toList();

    }

    @Override
    public void destroy(List<CountryDto> countryDtoList) {
        countryRepository.deleteAll(countryDtoList.stream().map(DtoMapper::mapToCountryEntity).toList());

    }

    @Override
    public List<CountryDto> listCountries() {
        return countryRepository.findAll().stream().map(DtoMapper::mapToCountryDto).toList();
    }

}
