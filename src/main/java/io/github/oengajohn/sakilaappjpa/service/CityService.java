package io.github.oengajohn.sakilaappjpa.service;

import io.github.oengajohn.sakilaappjpa.controller.dto.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> listCities();

    List<CityDto> saveOrUpdate(List<CityDto> cityDtoList);

    void destroy(List<CityDto> cityDtoList);
}
