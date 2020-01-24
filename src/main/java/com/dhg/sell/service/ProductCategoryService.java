package com.dhg.sell.service;

import com.dhg.sell.domain.ProductCategory;

import java.util.List;

public interface ProductCategoryService{
    ProductCategory insertCategory(ProductCategory category);

    void deleteCategoryById(Long id);

    void updateCategory(ProductCategory category);

    ProductCategory queryCategoryById(Long id);

    List<ProductCategory> queryAllCategories();


}
