package com.dhg.sell.service.impl;


import com.dhg.sell.domain.ProductCategory;
import com.dhg.sell.repository.ProductCategoryRepository;
import com.dhg.sell.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
    @Resource
    private ProductCategoryRepository repository;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;
    @Resource
    private  JdbcTemplate secondaryJdbcTemplate;

    @Override
    public ProductCategory insertCategory(ProductCategory category) {
        repository.insertCategory(category,primaryJdbcTemplate);
        repository.insertCategory(category,secondaryJdbcTemplate);
        return category;
    }

    @Override
    public void deleteCategoryById(Long id) {
        repository.deleteCategoryById(id,secondaryJdbcTemplate);
    }

    @Override
    public void updateCategory(ProductCategory category) {
        repository.updateCategory(category,primaryJdbcTemplate);
    }

    @Override
    public ProductCategory queryCategoryById(Long id) {
        return repository.queryCategoryById(id,primaryJdbcTemplate);
    }

    @Override
    public List<ProductCategory> queryAllCategories() {
        return repository.queryAllCategories(primaryJdbcTemplate);
    }
}
