package com.damiankoziel.forum.service;

import com.damiankoziel.forum.domain.Category;
import com.damiankoziel.forum.domain.DtoConverter.ToDtoConverter;
import com.damiankoziel.forum.dto.CategoryDto;
import com.damiankoziel.forum.exceptions.CategoryException;
import com.damiankoziel.forum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDto create(final Category category) {
        return ToDtoConverter.categoryToDto(this.categoryRepository.save(category));
    }

    public Iterable<CategoryDto> getAll() {
        return this.categoryRepository.findAll().stream()
                .map(ToDtoConverter::categoryToDto)
                .collect(Collectors.toList());
    }

    public CategoryDto getById(final Long id) {
        return ToDtoConverter.categoryToDto(this.categoryRepository.findById(id).orElseThrow(
                () -> new CategoryException("Category not found!")
                )
        );
    }

    public CategoryDto update(final Category category) {
        this.categoryRepository.findById(category.getId()).orElseThrow(
                () -> new CategoryException("Category not Found!")
        );
        return ToDtoConverter.categoryToDto(this.categoryRepository.save(category));
    }

    public void delete(final Long id){
        this.categoryRepository.findById(id).orElseThrow(
                () -> new CategoryException("Category not Found!")
        );
        this.categoryRepository.deleteById(id);
    }
}
