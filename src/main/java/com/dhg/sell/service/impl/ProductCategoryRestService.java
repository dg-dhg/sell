package com.dhg.sell.service.impl;

import com.dhg.sell.domain.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductCategoryRestService{
    public String saveCategory(ProductCategory category) {
        /*沿用c的格式*/
        log.info("saveCategory{}", category);
        return "成功";    }

    public String removeCategory(Long id) {
        /*沿用c的格式*/

        log.info("removeCategory{}", id);
        return "remove...";
    }

    public String putCategory(Long id, ProductCategory category) {
        category.setCategoryId(id);
        log.info(" putCategory{}", category);
        return "put...";
    }

    public String getCategory(Long id) {
        /*无数据源，此处手动创建返回对象*/
        ProductCategory category = ProductCategory.builder().categoryId(id).categoryName("youngBeach").categoryType(123L).build();
        log.info("removeCategory{}", category);
        return "get。。。";
    }
}
