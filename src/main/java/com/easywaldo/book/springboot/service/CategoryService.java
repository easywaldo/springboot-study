package com.easywaldo.book.springboot.service;

import com.easywaldo.book.springboot.domain.products.Category;
import com.easywaldo.book.springboot.domain.products.CategoryRepository;
import com.easywaldo.book.springboot.web.dto.CategorySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository _categoryRepository;

    private static CachingService _cachingService = new CachingService();

    public Category selectCategoryById(Integer id) {
        Optional<Category> result = _categoryRepository.findById(id);
        return  result.get();
    }

    public List<Category> selectAllCategory() throws Exception {
        List<Category> result =  null;

        result = (List<Category>)_cachingService.GetCache("selectAllCategory");
        if (_cachingService.GetCount() == 0 || result == null) {
            result = _categoryRepository.findAll();
            _cachingService.AddCache("selectAllCategory", result);
        }
        return  result;
    }

    @Transactional
    public Integer save(CategorySaveRequestDto categorySaveRequestDto) {
        return _categoryRepository.save(categorySaveRequestDto.toEntity()).getId();
    }

}
