package com.damiankoziel.forum.controller;

import com.damiankoziel.forum.domain.Category;
import com.damiankoziel.forum.dto.CategoryDto;
import com.damiankoziel.forum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody final Category category) {
        return new ResponseEntity<>(this.categoryService.create(category), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(this.categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable final Long id) {
        return new ResponseEntity<>(this.categoryService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody final Category category) {
        return new ResponseEntity<>(this.categoryService.update(category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoryById(@PathVariable final Long id) {
        this.categoryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
