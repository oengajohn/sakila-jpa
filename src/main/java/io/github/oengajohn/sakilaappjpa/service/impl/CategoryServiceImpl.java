package io.github.oengajohn.sakilaappjpa.service.impl;

import io.github.oengajohn.sakilaappjpa.component.DtoMapper;
import io.github.oengajohn.sakilaappjpa.controller.dto.CategoryDto;
import io.github.oengajohn.sakilaappjpa.entity.Category;
import io.github.oengajohn.sakilaappjpa.repository.CategoryRepository;
import io.github.oengajohn.sakilaappjpa.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> saveOrUpdate(List<CategoryDto> categoryDtoList) {
        List<Category> list = categoryDtoList.stream().map(DtoMapper::mapToCategoryEntity).toList();
        return categoryRepository.saveAll(list).stream().map(DtoMapper::mapToCategoryDto).toList();
    }

    @Override
    public void destroy(List<CategoryDto> categoryDtoList) {
        categoryRepository.deleteAll(categoryDtoList.stream().map(DtoMapper::mapToCategoryEntity).toList());

    }

    @Override
    public List<CategoryDto> findCategoriesByFilmId(int filmId) {
        return categoryRepository.findCategoriesByFilmId(filmId).stream().map(DtoMapper::mapToCategoryDto).toList();
    }

    @Override
    public List<CategoryDto> listCategories() {
        return categoryRepository.findAll().stream().map(DtoMapper::mapToCategoryDto).toList();
    }

}
