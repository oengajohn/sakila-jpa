package io.github.oengajohn.sakilaappjpa.controller;

import io.github.oengajohn.sakilaappjpa.controller.dto.CategoryDto;
import io.github.oengajohn.sakilaappjpa.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaappjpa.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/category")
@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("list")
    public GenericResponse<List<CategoryDto>> list(){
        return GenericResponse.success(
                categoryService.listCategories()
        );
    }

    @PostMapping("saveOrUpdate")
    public GenericResponse<List<CategoryDto>> saveOrUpdate(@RequestBody List<CategoryDto> categoryDtoList){
        return GenericResponse.success(
                categoryService.saveOrUpdate(categoryDtoList)
        );
    }
    @DeleteMapping("destroy")
    public GenericResponse<?> destroy(@RequestBody List<CategoryDto> categoryDtoList){
        categoryService.destroy(categoryDtoList);

        return GenericResponse.success(
        );
    }
}
