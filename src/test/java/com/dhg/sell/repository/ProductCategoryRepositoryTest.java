package com.dhg.sell.repository;

import com.dhg.sell.domain.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
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

@Resource
private JdbcTemplate primaryJdbcTemplate;
@Resource
private JdbcTemplate secondaryJdbcTemplate;
    @Test
    public void insertCategory() {
        ProductCategory category = ProductCategory.builder()
                .categoryId(5L)
                .categoryType(3L)
                .categoryName("热辣生鲜")
                .createTime(new Timestamp(System.currentTimeMillis()))
                .updateTime(new Timestamp(System.currentTimeMillis()))
                .build();
        repository.insertCategory(category,primaryJdbcTemplate);
        System.out.println(category);
    }

    @Test
    public void deleteCategoryById() {
        repository.deleteCategoryById(1L,primaryJdbcTemplate);
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
        repository.updateCategory(category,primaryJdbcTemplate);
    }

    @Test
    public void queryCategoryById() {
        ProductCategory category = repository.queryCategoryById(5L,primaryJdbcTemplate);
        System.out.println(category);
    }

    @Test
    public void queryAllCategories() {
        List<ProductCategory> categories = repository.queryAllCategories(primaryJdbcTemplate);
        for(ProductCategory each : categories) {
            System.out.println(each);
        }
    }
}