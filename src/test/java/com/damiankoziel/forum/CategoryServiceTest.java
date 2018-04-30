package com.damiankoziel.forum;

import com.damiankoziel.forum.domain.Category;
import com.damiankoziel.forum.repository.CategoryRepository;
import com.damiankoziel.forum.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    private Category category;

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryService categoryService;

    @Test
    public void shouldCreateCategoryTest() {
        category = new Category();
        categoryService = new CategoryService(categoryRepository);
        categoryService.create(category);

        verify(categoryRepository).save(category);
    }

    @Test
    public void shouldGetAllCategoriesTest() {
        category = new Category();
        Category category2 = new Category();
        categoryService = new CategoryService(categoryRepository);
        categoryService.create(category);
        categoryService.create(category2);

        categoryService.getAll();
        verify(categoryRepository).findAll();
    }

    @Test
    public void shouldDeleteCategoryByIdTest() {
        category = new Category();
        categoryService = new CategoryService(categoryRepository);
        categoryService.create(category);

        categoryService.delete(1L);
        verify(categoryRepository).deleteById(1L);
    }

}
