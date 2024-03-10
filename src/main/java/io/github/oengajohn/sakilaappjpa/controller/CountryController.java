package io.github.oengajohn.sakilaappjpa.controller;

import io.github.oengajohn.sakilaappjpa.controller.dto.CountryDto;
import io.github.oengajohn.sakilaappjpa.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaappjpa.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/country")
@RestController
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("list")
    public GenericResponse<List<CountryDto>> list(){
        return GenericResponse.success(
                countryService.listCountries()
        );
    }
    @PostMapping("saveOrUpdate")
    public GenericResponse<List<CountryDto>> saveOrUpdate(@RequestBody List<CountryDto> countryDtoList){
        return GenericResponse.success(
                countryService.saveOrUpdate(countryDtoList)
        );
    }
    @DeleteMapping("destroy")
    public GenericResponse<?> destroy(@RequestBody List<CountryDto> countryDtoList){
        countryService.destroy(countryDtoList);

        return GenericResponse.success(
        );
    }
}
