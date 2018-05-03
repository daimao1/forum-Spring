package com.damiankoziel.forum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    private Category category;

    @Mock
    private CategoryService categoryService;

    private CategoryController categoryController;

    @Test
    public void shouldCreateCategoryTest() {
        category = new Category();
        categoryController = new CategoryController(categoryService);
        categoryController.createCategory(category);

        verify(categoryService).create(category);
    }

    @Test
    public void shouldGetAllCategoriesTest() {
        category = new Category();
        Category category2 = new Category();
        categoryController = new CategoryController(categoryService);
        categoryController.createCategory(category);
        categoryController.createCategory(category2);
        categoryController.getAllCategories();

        verify(categoryService).getAll();
    }

    @Test
    public void shouldGetCategoryByIdTest() {
        category = new Category();
        categoryController = new CategoryController(categoryService);
        categoryController.createCategory(category);

        categoryController.getCategoryById(1L);
        verify(categoryService).getById(1L);
    }

    @Test
    public void shouldDeleteCategoryByIdTest() {
        category = new Category();
        categoryController = new CategoryController(categoryService);
        categoryController.createCategory(category);

        categoryController.deleteCategoryById(1L);
        verify(categoryService).delete(1L);
    }

}
