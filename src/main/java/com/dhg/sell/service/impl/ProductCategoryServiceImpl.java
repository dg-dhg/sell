package com.dhg.sell.service.impl;


import com.dhg.sell.domain.ProductCategory;
import com.dhg.sell.repository.ProductCategoryRepository;
import com.dhg.sell.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
    @Resource
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory insertCategory(ProductCategory category) {
        repository.insertCategory(category);
        return category;
    }

    @Override
    public void deleteCategoryById(Long id) {
        repository.deleteCategoryById(id);
    }

    @Override
    public void updateCategory(ProductCategory category) {
        repository.updateCategory(category);
    }

    @Override
    public ProductCategory queryCategoryById(Long id) {
        return repository.queryCategoryById(id);
    }

    @Override
    public List<ProductCategory> queryAllCategories() {
        return repository.queryAllCategories();
    }
}
