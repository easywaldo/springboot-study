package com.easywaldo.book.springboot.web;


import com.easywaldo.book.springboot.domain.products.Category;
import com.easywaldo.book.springboot.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@EnableCaching
@RestController
public class CategoryController {

    @Autowired
    private CategoryService _categoryService;

    @GetMapping("/api/v1/category/select/{id}")
    public Category select(@PathVariable Integer id) {
        return _categoryService.selectCategoryById(id);
    }

    @Cacheable(value = "selectAllCategory")
    @GetMapping("/api/v1/category/select")
    public List<Category> selectAllCategory() {
        return _categoryService.selectAllCategory();
    }

}
