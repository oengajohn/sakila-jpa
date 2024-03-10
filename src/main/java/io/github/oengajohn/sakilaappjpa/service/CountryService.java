package io.github.oengajohn.sakilaappjpa.service;

import io.github.oengajohn.sakilaappjpa.controller.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> listCountries();

    List<CountryDto> saveOrUpdate(List<CountryDto> countryDtoList);

    void destroy(List<CountryDto> countryDtoList);
}
