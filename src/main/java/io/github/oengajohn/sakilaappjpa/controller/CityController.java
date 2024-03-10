package io.github.oengajohn.sakilaappjpa.controller;

import io.github.oengajohn.sakilaappjpa.controller.dto.CityDto;
import io.github.oengajohn.sakilaappjpa.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaappjpa.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/city")
@RestController
public class CityController {
    private final CityService cityService;

    public CityController(CityService categoryService) {
        this.cityService = categoryService;
    }

    @GetMapping("list")
    public GenericResponse<List<CityDto>> list(){
        return GenericResponse.success(
                cityService.listCities()
        );
    }
    @PostMapping("saveOrUpdate")
    public GenericResponse<List<CityDto>> saveOrUpdate(@RequestBody List<CityDto> cityDtoList){
        return GenericResponse.success(
                cityService.saveOrUpdate(cityDtoList)
        );
    }
    @DeleteMapping("destroy")
    public GenericResponse<?> destroy(@RequestBody List<CityDto> cityDtoList){
        cityService.destroy(cityDtoList);

        return GenericResponse.success(
        );
    }
}
