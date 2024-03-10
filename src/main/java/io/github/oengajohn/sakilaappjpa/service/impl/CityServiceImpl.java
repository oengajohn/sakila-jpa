package io.github.oengajohn.sakilaappjpa.service.impl;

import io.github.oengajohn.sakilaappjpa.component.DtoMapper;
import io.github.oengajohn.sakilaappjpa.controller.dto.CityDto;
import io.github.oengajohn.sakilaappjpa.entity.City;
import io.github.oengajohn.sakilaappjpa.repository.CityRepository;
import io.github.oengajohn.sakilaappjpa.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDto> saveOrUpdate(List<CityDto> cityDtoList) {
        List<City> list = cityDtoList.stream().map(DtoMapper::mapToCityEntity).toList();
        return cityRepository.saveAll(list).stream().map(DtoMapper::mapToCityDto).toList();

    }

    @Override
    public void destroy(List<CityDto> cityDtoList) {
        cityRepository.deleteAll(cityDtoList.stream().map(DtoMapper::mapToCityEntity).toList());

    }

    @Override
    public List<CityDto> listCities() {
        return cityRepository.findAll().stream().map(DtoMapper::mapToCityDto).toList();
    }

}
