package io.github.oengajohn.sakilaappjpa.service;

import io.github.oengajohn.sakilaappjpa.controller.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> listCategories();
    List<CategoryDto> findCategoriesByFilmId(int filmId);

    List<CategoryDto> saveOrUpdate(List<CategoryDto> categoryDtoList);

    void destroy(List<CategoryDto> categoryDtoList);
}
