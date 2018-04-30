package com.damiankoziel.forum.service;

import com.damiankoziel.forum.domain.Category;
import com.damiankoziel.forum.dto.DtoConverter.ToDtoConverter;
import com.damiankoziel.forum.dto.CategoryDto;
import com.damiankoziel.forum.exceptions.CategoryException;
import com.damiankoziel.forum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDto create(final Category category) {
        this.categoryRepository.save(category);
        return ToDtoConverter.categoryToDto(category);
    }

    public Collection<CategoryDto> getAll() {
        Collection<Category> categories = this.categoryRepository.findAll();
        return categories.stream()
                .map(ToDtoConverter::categoryToDto)
                .collect(Collectors.toList());
    }

    public CategoryDto getById(final Long id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(
                () -> new CategoryException("Can't get. Category not found!")
        );
        return ToDtoConverter.categoryToDto(category);
    }

    public CategoryDto update(final Category category) {
        this.categoryRepository.findById(category.getId()).orElseThrow(
                () -> new CategoryException("Can't update. Category not Found!")
        );
        this.categoryRepository.save(category);
        return ToDtoConverter.categoryToDto(category);
    }

    public void delete(final Long id){
        this.categoryRepository.deleteById(id);
    }
}
