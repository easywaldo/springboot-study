package com.easywaldo.book.springboot.service;

import com.easywaldo.book.springboot.domain.products.Category;
import com.easywaldo.book.springboot.domain.products.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository _categoryRepository;

    public Category selectCategoryById(Integer id) {
        Optional<Category> result = _categoryRepository.findById(id);
        return  result.get();
    }

    public List<Category> selectAllCategory() {
            return _categoryRepository.findAll();
    }

}
