package com.dhg.sell.repository;

import com.dhg.sell.domain.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
class ProductCategoryRepositoryTest{
    @Resource
    private ProductCategoryRepository repository;


    @Test
    public void insertCategory() {
        ProductCategory category = ProductCategory.builder()
                .categoryId(5L)
                .categoryType(3L)
                .categoryName("热辣生鲜")
                .createTime(new Timestamp(System.currentTimeMillis()))
                .updateTime(new Timestamp(System.currentTimeMillis()))
                .build();
        repository.insertCategory(category);
        System.out.println(category);
    }

    @Test
    public void deleteCategoryById() {
        repository.deleteCategoryById(1L);
    }

    @Test
    public void updateCategory() {
        ProductCategory category = ProductCategory.builder()
                .categoryId(5L)
                .categoryType(2L)
                .categoryName("精制早点")
                .createTime(new Timestamp(System.currentTimeMillis()))
                .updateTime(new Timestamp(System.currentTimeMillis()))
                .build();
        repository.updateCategory(category);
    }

    @Test
    public void queryCategoryById() {
        ProductCategory category = repository.queryCategoryById(5L);
        System.out.println(category);
    }

    @Test
    public void queryAllCategories() {
        List<ProductCategory> categories = repository.queryAllCategories();
        for(ProductCategory each : categories) {
            System.out.println(each);
        }
    }
}